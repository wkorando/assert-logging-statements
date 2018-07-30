package com.bk.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

public class TestLocalAppender {

	@Test
	public void testLocalAppenderA() {
		LogProducingService service = new LogProducingService();
		
		LocalAppender localAppender = new LocalAppender();
		localAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
		Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		logger.addAppender(localAppender);
		
		service.writeSomeLoggingStatements("Local appender");
		assertThat(localAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! Local appender",
				"This message is in a separate thread");
		
		LocalAppender.cleanup(localAppender);
	}
	
	@Test
	public void testLocalAppenderB() {
		LogProducingService service = new LogProducingService();
		
		LocalAppender localAppender = new LocalAppender();
		localAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
		Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		logger.addAppender(localAppender);
		
		service.writeSomeLoggingStatements("Local appender");
		assertThat(localAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! Local appender",
				"This message is in a separate thread");
		
		LocalAppender.cleanup(localAppender);
	}

}
