package com.bk.logging;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class LocalAppender extends AppenderBase<ILoggingEvent> {
	private List<ILoggingEvent> events = new ArrayList<>();

	public LocalAppender() {
		start();
	}

	@Override
	public void append(ILoggingEvent e) {
		events.add(e);
	}

	public List<ILoggingEvent> getEvents() {
		return events;
	}

	public void clearEvents() {
		events.clear();
	}
}
