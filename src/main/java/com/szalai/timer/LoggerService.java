package com.szalai.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class LoggerService {

    @Scheduled(fixedDelay = 2000)
    public void generateLog(){
        log.info("Current date time: {}", LocalDateTime.now());
    }
}
