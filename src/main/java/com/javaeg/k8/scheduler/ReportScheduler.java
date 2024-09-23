package com.javaeg.k8.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("reportScheduler")
public class ReportScheduler implements Scheduler {

	private static final Logger logger = LoggerFactory.getLogger(ReportScheduler.class);

	@Override
	public void execute() {
		logger.info("Running daily scheduler...");
	}
}
