package de.oetting.jws.server;

import javax.xml.ws.Endpoint;

public class EndpointPublisher {

	 public static void main(String[] args){
		 Endpoint.publish("http://localhost:1234/bla", new CalculatorService());
	 }
	 
}
 