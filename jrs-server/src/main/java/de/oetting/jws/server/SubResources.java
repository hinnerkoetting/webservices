package de.oetting.jws.server;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;

@Path("resource")
public class SubResources extends Application{

	@Path("/calc/{num1}/{num2}")
	public Calc calc(@PathParam(value="num1") int num1, @PathParam(value="num2") int num2) {
		return new Calc(num1, num2);
	}

}
