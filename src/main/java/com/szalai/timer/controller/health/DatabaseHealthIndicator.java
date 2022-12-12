package com.szalai.timer.controller.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    Logger logger = LoggerFactory.getLogger(DatabaseHealthIndicator.class);
    private final String DATABASE_NAME = "DatabaseService";

    @Override
    public Health health() {
        if (isDatabaseHealthy()){
            logger.info("{} is UP and healthy", DATABASE_NAME);
            return Health.up().withDetail("Service is running ", DATABASE_NAME).build();
        }
        logger.info("{} is DOWN and not healthy", DATABASE_NAME);
        return Health.up().withDetail("Service not available ", DATABASE_NAME).build();
    }

    private boolean isDatabaseHealthy(){
        //TODO
        return true;
    }
}
