package com.bk.logging;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class StaticLogbackAppender extends AppenderBase<LoggingEvent> {
	static ThreadLocal<List<LoggingEvent>> threadLocal = new ThreadLocal<>();
	
	@Override
	public void append(LoggingEvent e) {
		List<LoggingEvent> events = threadLocal.get();
		if(events == null) {
			events = new ArrayList<>();
			threadLocal.set(events);
		}
		events.add(e);
	}

	public static List<LoggingEvent> getEvents() {
		return threadLocal.get();
	}

	public static void clearEvents() {
		threadLocal.remove();
	}
}
