package com.bk.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLogProducingService {

	@BeforeEach
	public void clearLoggingStatements() {
		StaticLoggingAppender.clearEvents();
	}

	@Test
	public void testAssertingLoggingStatements() {
		LogProducingService service = new LogProducingService();
		service.writeSomeLoggingStatements();
		assertThat(StaticLoggingAppender.getEvents()).extracting("message").contains("Let's assert some logs!");
	}
}
