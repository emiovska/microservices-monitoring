package com.msm.sr.service.status.notification.demo;

import com.msm.sr.service.status.notification.listener.ServiceStatusListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class DemoListener implements ServiceStatusListener {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void notifyForRegistration(String... parameters) {
        LOGGER.debug("notification for registration obtained");
    }

    @Override
    public void notifyForDeregistration(String... parameters) {
        LOGGER.debug("notification for registration deobtained");
    }
}
