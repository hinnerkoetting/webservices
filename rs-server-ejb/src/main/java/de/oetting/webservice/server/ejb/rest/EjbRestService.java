package de.oetting.webservice.server.ejb.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;

@Path("add")
@Stateless
public class EjbRestService extends Application {

	@Path("{int1}/{int2}")
	@GET
	public String add(@PathParam("int1") int i1, @PathParam("int2") int i2) {
		return "" + (i1 + i2);
	}
}
