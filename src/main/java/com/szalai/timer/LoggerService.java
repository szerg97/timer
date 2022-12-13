package com.szalai.timer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Properties;

@Service
@Slf4j
public class LoggerService {

    private static Properties properties = new Properties();

    @Value("${logging.logcontrol}")
    private String logcontrolYaml = "";

    @Value("classpath:logcontrol.json")
    private Resource logcontrolClasspath;

    private static final String LOG_CONTROL_CONFIG_PROPERTY = "log.control.config.path";
    private static final String LOG_CONTROL_CONFIG_PATH = properties.getProperty(LOG_CONTROL_CONFIG_PROPERTY, "");
    private static final String LOG_CONTROL_JSON_FILENAME = "logcontrol.json";
    private static final String TIMER_CONTAINER_NAME = "timer";

    @Scheduled(fixedDelay = 2000)
    public void generateLog() throws IOException {
        Path path = Paths.get(logcontrolYaml).toAbsolutePath();
        ObjectMapper objectMapper = new ObjectMapper();
        LogControl[] examples = objectMapper.readValue(path.toFile(), LogControl[].class);
        for (LogControl example:examples
             ) {
            log.info("container: {} with severity: {}", example.getContainer(), example.getSeverity());
        }

        log.info("Current date time: {}", LocalDateTime.now());

        File file = logcontrolClasspath.getFile();
        ObjectMapper objectMapper1 = new ObjectMapper();
        LogControl[] examples1 = objectMapper1.readValue(file, LogControl[].class);
        for (LogControl example:examples1
        ) {
            log.info("container: {} with severity: {}", example.getContainer(), example.getSeverity());
        }

        /////////////////////////////////////

        Path p = Paths.get("").toAbsolutePath();
        System.out.println(p);

        Path path2 = Paths.get(LOG_CONTROL_JSON_FILENAME);
        File file2 = path2.toFile();
        ObjectMapper objectMapper2 = new ObjectMapper();
        LogControl[] examples2 = objectMapper2.readValue(file2, LogControl[].class);
        for (LogControl example:examples2
        ) {
            log.info("container: {} with severity: {}", example.getContainer(), example.getSeverity());
        }
    }
}
