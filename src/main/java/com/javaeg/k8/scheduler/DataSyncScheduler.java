package com.javaeg.k8.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("dataSyncScheduler")
public class DataSyncScheduler implements Scheduler {

	private static final Logger logger = LoggerFactory.getLogger(DataSyncScheduler.class);

	@Override
	public void execute() {
		logger.info("Running dataSyncScheduler scheduler...");
	}
}
