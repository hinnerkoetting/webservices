package de.oetting.jws.client;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AsyncClientTest {

	@Test
	public void execute_always_returnsSum() {
		int sum = new AsyncClient().executeAsync(1, 2);
		assertThat(sum, is(equalTo(3)));
	}

}
