package com.msm.ssr.listeners;

import com.msm.property.file.loader.service.PropertiesFilesService;
import com.msm.ssr.exceptions.ApplicationServerUrlException;
import com.msm.ssr.properties.representations.ServiceProperties;
import com.msm.ssr.rest.controller.HealthCheckController;
import com.msm.ssr.services.ServiceRegistrationService;
import com.msm.ssr.utils.ApplicationServerUtils;
import com.msm.ssr.utils.PathAnnotationValueUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class CustomServletContextListener implements ServletContextListener {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private static final ServiceRegistrationService registrationService = new ServiceRegistrationService();
    private static final String HEALTH_CHECK_METHOD_NAME = "healthCheck";

    private static final int IP_ADDRESS = 0;
    private static final int HOSTNAME_ADDRESS = 1;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextInitialized");
        try {
            List<String> urls = ApplicationServerUtils.getServerUrl(servletContextEvent.getServletContext().getContextPath());
            String serviceHost = urls.get(IP_ADDRESS);
            ServiceProperties properties = PropertiesFilesService.getPropertiesResource(ServiceProperties.class);

            String useHostnameOverIp = properties.getUseHostnameOverIp();
            if (useHostnameOverIp != null && useHostnameOverIp.equals("true")) {
                serviceHost = urls.get(HOSTNAME_ADDRESS);
            }

            String healthCheckEndpoint = properties.getHealthCheckEndpoint();
            boolean successfullySetPath = PathAnnotationValueUtils.adaptMethodPath(HealthCheckController.class, HEALTH_CHECK_METHOD_NAME, healthCheckEndpoint);
            if (successfullySetPath) {
                LOGGER.debug("path successfully overridden");
            } else {
                LOGGER.debug("could not override path");
            }

            boolean isSuccessfullyRegistered = registrationService.register(properties.getRegistrarHost(), properties.getRegistrationEndpoint(), properties.getId(), serviceHost, healthCheckEndpoint);

            if (isSuccessfullyRegistered) {
                LOGGER.debug("successfully registered");
            } else {
                LOGGER.debug("unsuccessfully registered");
            }
        } catch (ApplicationServerUrlException e) {
            e.printStackTrace();
            LOGGER.debug("Could not construct the server urls");
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextDestroyed");
        ServiceProperties properties = PropertiesFilesService.getPropertiesResource(ServiceProperties.class);
        boolean isSuccessful = registrationService.unregister(properties.getRegistrarHost(), properties.getDeregistrationEndpoint(), properties.getId());

        if (isSuccessful) {
            LOGGER.debug("successfully unregistered");
        } else {
            LOGGER.debug("unsuccessfully unregistered");
        }
    }
}
