package de.oetting.jws.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Holder;
import javax.xml.ws.Response;

import de.oetting.jws.server.AddResponse;
import de.oetting.jws.server.AdditionService;
import de.oetting.jws.server.HandlerChainService;

public class AsyncClient {

	public int executeAsync(int i1, int i2) {
		Response<AddResponse> addAsync = new AdditionService()
				.getHandlerChainServicePort().addAsync(i1, i2);
		while (!addAsync.isDone()) {
			sleep(10);
		}
		return extractResult(addAsync);
	}
	
	public int executeWithDispatch(int i1, int i2) {
		HandlerChainService port = new AdditionService().getPort(HandlerChainService.class);
		Holder<Integer> resultHolder = new Holder<Integer>();
		resultHolder.value = -1;
		port.addAsync(i1, i2, new AsyncHandler<AddResponse>() {
			
			@Override
			public void handleResponse(Response<AddResponse> res) {
				resultHolder.value = extractResult(res);
			}
		});
		sleep(50);
		return resultHolder.value;
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// Ignore
		}
	}

	private int extractResult(Response<AddResponse> addAsync) {
		try {
			return addAsync.get().getReturn();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
