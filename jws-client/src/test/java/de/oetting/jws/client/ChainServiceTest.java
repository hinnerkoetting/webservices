package de.oetting.jws.client;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ChainServiceTest {

	@Test
	public void add_forSmallNumber_returnsSumOfBothValues() {
		int sum = whenAdding(1, 2);
		assertThat(sum, is(3));
	}

	@Test(expected = Exception.class)
	public void add_forBigNumber_throwsException() {
		whenAdding(11, 12);
	}

	private int whenAdding(int i, int j) {
		return new ChainService().add(i, j);
	}

}
