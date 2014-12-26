package de.oetting.jws.client;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.Response;

import de.oetting.jws.server.AddResponse;
import de.oetting.jws.server.AdditionService;

public class AsyncClient {

	public int executeAsync(int i1, int i2) {
		Response<AddResponse> addAsync = new AdditionService()
				.getHandlerChainServicePort().addAsync(i1, i2);
		while (!addAsync.isDone()) {
			sleep(10);
		}
		return extractResult(addAsync);
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
