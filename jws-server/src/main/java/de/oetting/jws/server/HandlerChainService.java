package de.oetting.jws.server;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(serviceName= "AdditionService")
@HandlerChain(file = "handlers.xml")
public class HandlerChainService {

	public int add(int value1, int value2) {
		return value1 + value2;
	}
}
