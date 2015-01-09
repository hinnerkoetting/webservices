package de.oetting.jws.server.endpointInterface;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SeiService extends SeiSuperService{

	@WebMethod
	void foo(int b);
}
