package de.oetting.webservice.server.ejb.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;

//accessed from http://localhost:8090/jrs-server/rest/ejb/add/1/2 only via war-project
@Path("ejb")
@Stateless
public class EjbRestService extends Application {

	@Path("add/{int1}/{int2}")
	@GET
	public String add(@PathParam("int1") int i1, @PathParam("int2") int i2) {
		return "" + (i1 + i2);
	}
}
