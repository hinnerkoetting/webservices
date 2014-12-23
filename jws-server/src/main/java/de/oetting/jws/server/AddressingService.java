package de.oetting.jws.server;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@WebService()
@Addressing
public class AddressingService {

	public int divide(int numerator, int divisor) {
		return numerator / divisor;
	}
}
