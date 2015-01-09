package de.oetting.jws.server;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService
public class WebserviceContextService {

	@Resource
	private WebServiceContext context;
	
	public void foo(int i) {
		
	}
}
