package de.oetting.certificate.rs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class JerseyClient {

	public int execute(int i1, int i2) {
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8090/jrs-server/rest/resource/calc/1/2/add");
		String result = resource.get(String.class);
		return Integer.valueOf(result);
	}
}
