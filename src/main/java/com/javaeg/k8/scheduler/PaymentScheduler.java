package com.javaeg.k8.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("paymentScheduler")
public class PaymentScheduler implements Scheduler {

	private static final Logger logger = LoggerFactory.getLogger(PaymentScheduler.class);

	@Override
	public void execute() {
		logger.info("Running payment scheduler...");
	}
}
