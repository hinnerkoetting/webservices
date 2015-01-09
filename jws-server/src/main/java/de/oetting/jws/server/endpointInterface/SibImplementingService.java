package de.oetting.jws.server.endpointInterface;

import javax.jws.WebService;

//test which methods get published
@WebService
public class SibImplementingService implements SeiService {

	public void bar(int a) {
	}

	public void foo(int b) {
	}

}
