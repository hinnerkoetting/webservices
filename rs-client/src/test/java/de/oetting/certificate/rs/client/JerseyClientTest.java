package de.oetting.certificate.rs.client;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class JerseyClientTest {

	@Test
	public void execute_always_returnsSum() {
		int sum = new JerseyClient().execute(1, 2);
		assertThat(sum, is(equalTo(3)));
	}

}
