package de.oetting.jws.server;

import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

import de.oetting.generated.CalculatorService;
import de.oetting.generated.CalculatorServiceService;

@WebService
public class WebserviceRef {

	@WebServiceRef(value = CalculatorServiceService.class)
	private CalculatorService calcService;

	public int subtract(int i1, int i2) throws Exception {
		return calcService.subtract(i1, i2);
	}
}
