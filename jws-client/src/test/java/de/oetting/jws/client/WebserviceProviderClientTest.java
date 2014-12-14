package de.oetting.jws.client;

import org.junit.Test;

public class WebserviceProviderClientTest {

	@Test
	public void callServer_doesNotThrowException() throws Exception {
		whenCallingServer();
	}

	private void whenCallingServer() throws Exception {
		WebserviceProviderClient classUnderTest = new WebserviceProviderClient();
		classUnderTest.callService();
	}

}
