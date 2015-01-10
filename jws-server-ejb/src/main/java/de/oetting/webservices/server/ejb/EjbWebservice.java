package de.oetting.webservices.server.ejb;

import javax.ejb.Stateless;
import javax.jws.WebService;

//accessable at http://localhost:8090/jws-server-ejb-0.0.1-SNAPSHOT/EjbWebservice?wsdl (maybe port has to change)
@WebService
@Stateless
public class EjbWebservice {

	public void foo(int i) {
	}
	
}
