package de.oetting.jws.server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

@Path("calculator")
public class Calculator extends Application implements LocalCalc{

	public String bla() {
		return "bla";
	}
	
	@GET
	@Path("c")
	public String blubb() {
		return "bla";
	} 
}
