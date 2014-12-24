package de.oetting.jws.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Service;

@WebService
public class CalculatorService {

	public int add(int i1, int i2) throws Exception {
		throw new Exception();
	}

	public int subtract(int i1, int i2) {
		return i1 - i2;
	}
	
	@WebMethod(exclude=true)
	public int multiply(int i1, int i2) {
		return i1 - i2;
	}
	
	
	public int divide(javax.xml.ws.Holder<Integer> i1, int i2) {
		
		int result =  i1.value / i2;
		i1.value--;
		return result;
	}
	
}
