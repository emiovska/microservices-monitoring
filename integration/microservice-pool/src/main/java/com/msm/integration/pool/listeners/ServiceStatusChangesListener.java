package com.msm.integration.pool.listeners;

import com.msm.sr.service.status.notification.listener.ServiceStatusListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public class ServiceStatusChangesListener implements ServiceStatusListener {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void notifyForRegistration(String... parameters) {
        LOGGER.debug("notification for registration obtained, received parameters");
        logParameters(parameters);
    }

    @Override
    public void notifyForDeregistration(String... parameters) {
        LOGGER.debug("notification for registration obtained, received parameters");
        logParameters(parameters);
    }

    private void logParameters(String... parameters) {
        for (String parameter : parameters) {
            LOGGER.debug(parameter);
        }
    }

}
