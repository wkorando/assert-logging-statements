package com.bk.logging;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class ThreadLocalLogbackAppender extends AppenderBase<LoggingEvent> {
	static List<LoggingEvent> events = new ArrayList<>();
	
	@Override
	public void append(LoggingEvent e) {
		events.add(e);
	}

	public static List<LoggingEvent> getEvents() {
		return events;
	}

	public static void clearEvents() {
		events.clear();
	}
}
