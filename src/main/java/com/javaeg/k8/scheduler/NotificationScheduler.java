package com.javaeg.k8.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("notificationScheduler")
public class NotificationScheduler implements Scheduler {

	private static final Logger logger = LoggerFactory.getLogger(NotificationScheduler.class);

	@Override
	public void execute() {
		logger.info("Running notification scheduler...");
	}
}
