package com.bk.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogProducingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogProducingService.class);

	public void writeSomeLoggingStatements() {
		LOGGER.info("Let's assert some logs!");
	}
}
