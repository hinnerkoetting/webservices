package de.oetting.jws.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WebserviceProviderClientTest {

	@Test
	public void callServer_returnsOk() throws Exception {
		String returnValue = whenCallingServer();
		assertEquals("ok", returnValue);
	}

	private String whenCallingServer() throws Exception {
		WebserviceProviderClient classUnderTest = new WebserviceProviderClient();
		return classUnderTest.callService();
	}

}
