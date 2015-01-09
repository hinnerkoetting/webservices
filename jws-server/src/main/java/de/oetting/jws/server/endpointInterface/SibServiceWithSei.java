package de.oetting.jws.server.endpointInterface;

import javax.jws.WebService;

//test which methods get published
@WebService(endpointInterface = "de.oetting.jws.server.endpointInterface.SeiSuperService")
public class SibServiceWithSei implements SeiService { 

	public void foo(int i) {
	}

	public void bar(int i) {
	}

	public void another(int i) {
	}

}
