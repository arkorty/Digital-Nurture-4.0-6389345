package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message. Something went wrong!");
        logger.warn("This is a warning message. Please be cautious.");
        logger.info("This is an info message. Application is starting.");
        logger.debug("This is a debug message with more details.");
        logger.trace("This is a trace message with even more details.");
    }
}
