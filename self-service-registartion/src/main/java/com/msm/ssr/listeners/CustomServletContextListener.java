package com.msm.ssr.listeners;

import com.msm.property.file.loader.service.PropertiesFilesService;
import com.msm.ssr.exceptions.ApplicationServerUrlException;
import com.msm.ssr.properties.representations.ServiceProperties;
import com.msm.ssr.rest.controller.HealthCheckController;
import com.msm.ssr.services.ServiceRegistrationService;
import com.msm.ssr.utils.ServerUtils;
import com.msm.ssr.utils.PathAnnotationUtils;
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
    private static final String HEALTH_CHECK_METHOD_NAME = "healthCheck";
    private static final ServiceRegistrationService SERVICE_REGISTRATION_SERVICE = new ServiceRegistrationService();

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextInitialized");
        try {
            ServiceProperties serviceProperties = PropertiesFilesService.getPropertiesResource(ServiceProperties.class);
            String serviceRunningAddress = ServerUtils.getServiceAddress(servletContextEvent.getServletContext().getContextPath(), serviceProperties);

            String healthCheckEndpoint = serviceProperties.getHealthCheckEndpoint();
            PathAnnotationUtils.changePathValue(HealthCheckController.class, HEALTH_CHECK_METHOD_NAME, healthCheckEndpoint);

            SERVICE_REGISTRATION_SERVICE.register(serviceProperties.getRegistrarHost(), serviceProperties.getRegistrationEndpoint(), serviceProperties.getId(), serviceRunningAddress, healthCheckEndpoint);
            SERVICE_REGISTRATION_SERVICE.deregister(serviceProperties.getRegistrarHost(), serviceProperties.getDeregistrationEndpoint(), serviceProperties.getId());
        } catch (ApplicationServerUrlException e) {
            e.printStackTrace();
            LOGGER.debug("Could not construct the server urls");
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextDestroyed");
        ServiceProperties serviceProperties = PropertiesFilesService.getPropertiesResource(ServiceProperties.class);
        SERVICE_REGISTRATION_SERVICE.deregister(serviceProperties.getRegistrarHost(), serviceProperties.getDeregistrationEndpoint(), serviceProperties.getId());
    }
}
