package com.bk.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestThreadLocalLogbackMessages {

	@BeforeEach
	public void clearLoggingStatements() {
		ThreadLocalLogbackAppender.clearEvents();
	}

	@Test
	public void testAssertingLoggingStatementsA() {
		LogProducingService service = new LogProducingService();
		service.writeSomeLoggingStatements("A");
		assertThat(ThreadLocalLogbackAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! A");
	}

	@Test
	public void testAssertingLoggingStatementsB() {
		LogProducingService service = new LogProducingService();
		service.writeSomeLoggingStatements("B");
		assertThat(ThreadLocalLogbackAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! B");
	}

}
