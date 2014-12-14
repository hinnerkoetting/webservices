package de.oetting.jws.server;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface LocalCalc {

	@POST
	@Path("b")
	public String bla();
	

	public String blubb();
}
