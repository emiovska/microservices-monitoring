package com.msm.ssr.listeners;

import com.msm.ssr.exceptions.ApplicationServerUrlException;
import com.msm.ssr.utils.ApplicationServerUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class CustomServletContextListener implements ServletContextListener {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextInitialized");
        try {
            List urls = ApplicationServerUtils.getServerUrl(servletContextEvent.getServletContext().getContextPath());
            LOGGER.debug("URLS obtained");
            LOGGER.debug(urls);
        } catch (ApplicationServerUrlException e) {
            e.printStackTrace();
            LOGGER.debug("Could not construct the server urls");
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextDestroyed");
    }
}
