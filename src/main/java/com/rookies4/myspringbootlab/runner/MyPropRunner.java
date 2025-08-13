package com.rookies4.myspringbootlab.runner;

import com.rookies4.myspringbootlab.property.MyPropProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyPropRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyPropRunner.class);
    private final MyPropProperties myPropProperties;

    @Override
    public void run(String... args) throws Exception {
        // System.out.println -> logger로 변경
        logger.info("Username: {}", myPropProperties.getUsername());
        logger.info("Port: {}", myPropProperties.getPort());
    }
}
