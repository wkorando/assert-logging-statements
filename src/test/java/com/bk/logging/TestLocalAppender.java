package com.bk.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

public class TestLocalAppender {

	@Test
	public void testLocalAppender() {
		LogProducingService service = new LogProducingService();
		LocalAppender localLogbackAppender = new LocalAppender();
		localLogbackAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
		Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		logger.addAppender(localLogbackAppender);
		service.writeSomeLoggingStatements("B");
		assertThat(localLogbackAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! B",
				"This message is in a separate thread");
	}

}
