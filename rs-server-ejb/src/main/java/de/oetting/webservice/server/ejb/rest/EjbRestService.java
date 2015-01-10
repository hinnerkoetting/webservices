package de.oetting.webservice.server.ejb.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;

@ApplicationPath("ejb")
@Path("test")
public class EjbRestService extends Application {

	@Path("add/{int1}/{int2}")
	public String add(@PathParam("int1") int i1, @PathParam("int2") int i2) {
		return "" + (i1 + i2);
	}
}
