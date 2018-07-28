package com.bk.logging;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogProducingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogProducingService.class);

	public void writeSomeLoggingStatements(String message) {
		LOGGER.info("Let's assert some logs! " + message);
		Executor executor = Executors.newFixedThreadPool(1);
		executor.execute(() -> LOGGER.info("This message is in a separate thread"));
		try {
			Thread.sleep(1L); //brief pause to allow other thread to complete
		} catch (InterruptedException e) {
			//no-op
		}
	}
}
