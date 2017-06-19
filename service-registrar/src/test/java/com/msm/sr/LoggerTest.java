package com.msm.sr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class LoggerTest {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void logSomething() {
        LOGGER.info("Show this in log");
    }

}
