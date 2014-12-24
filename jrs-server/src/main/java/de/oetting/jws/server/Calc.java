package de.oetting.jws.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class Calc {
	private final int i1;
	private final int i2;

	public Calc(int i1, int i2) {
		this.i1 = i1;
		this.i2 = i2;
	}

	@GET
	@Path("add")
	public String add() {
		return Integer.toString(i1 + i2);
	}

}