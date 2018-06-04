package org.apilytic.signet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelloWordTest {
	@Test
	public void main() {
		HelloWorld hw = new HelloWorld();
		assertNotNull(hw);
	}
}
