package com.javaeg.k8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javaeg.k8.scheduler.Scheduler;
import com.javaeg.k8.scheduler.SchedulerRegistry;

@SpringBootApplication
public class JobSchedulerApplication {

	private static final Logger logger = LoggerFactory.getLogger(JobSchedulerApplication.class);
	
	@Autowired
	private SchedulerRegistry schedulerRegistry;

	public static void main(String[] args) {
		SpringApplication.run(JobSchedulerApplication.class, args);
	}

	@Bean
	public CommandLineRunner runJob(@Value("${job.name}") String jobName) {
		return args -> {
			Scheduler scheduler = schedulerRegistry.getScheduler(jobName);
	        if (scheduler != null) {
	            scheduler.execute();
	        } else {
	        	logger.error("Scheduler not found: " + jobName);
	        }
		};
	}

}
