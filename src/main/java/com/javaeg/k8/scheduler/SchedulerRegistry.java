package com.javaeg.k8.scheduler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class SchedulerRegistry {

    private final Map<String, Scheduler> schedulerMap = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        Map<String, Scheduler> schedulers = applicationContext.getBeansOfType(Scheduler.class);
        schedulers.forEach((name, scheduler) -> schedulerMap.put(name, scheduler));
    }

    public Scheduler getScheduler(String name) {
        return schedulerMap.get(name);
    }
}

