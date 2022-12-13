package com.szalai.timer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
@Slf4j
public class LoggerService {

    @Value("${logging.logcontrol}")
    private String logcontrol = "";

    @Scheduled(fixedDelay = 2000)
    public void generateLog() throws IOException {
        Path path = Paths.get(logcontrol).toAbsolutePath();
        ObjectMapper objectMapper = new ObjectMapper();
        LogControl[] examples = objectMapper.readValue(path.toFile(), LogControl[].class);
        for (LogControl example:examples
             ) {
            log.info("container: {} with severity: {}", example.getContainer(), example.getSeverity());
        }

        log.info("Current date time: {}", LocalDateTime.now());
    }
}
