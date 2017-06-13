package com.msm.ssr.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class CustomServletContextListener implements ServletContextListener {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextDestroyed");
    }
}
