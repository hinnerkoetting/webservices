package de.oetting.jws.server;

import javax.jws.WebService;

@WebService(name = "LogService", serviceName="bla")
public class LogServiceImpl {

	public void log(String msg) {
		System.out.println(msg);
	}
}