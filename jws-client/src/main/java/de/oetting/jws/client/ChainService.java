package de.oetting.jws.client;

import de.oetting.jws.server.CalculatorService;
import de.oetting.jws.server.HandlerChainService;

public class ChainService {

	public int add(int value1, int value2) {
		CalculatorService service = new CalculatorService();
		HandlerChainService port = service.getHandlerChainServicePort();
		return port.add(value1, value2);
	}
}
