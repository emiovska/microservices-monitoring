package com.msm.sr.listeners;

import com.msm.endpoint.configurator.EndpointConfigurator;
import com.msm.property.file.loader.service.PropertiesFilesService;
import com.msm.sr.properties.representations.ServiceRegistrarProperties;
import com.msm.sr.rest.controllers.ServiceRegistrarController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class CustomServletContextListener implements ServletContextListener {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private static final String REGISTRATION_METHOD_NAME = "register";
    private static final String DEREGISTRATION_METHOD_NAME = "deregister";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.debug("Context initialized");
        ServiceRegistrarProperties properties = PropertiesFilesService.getPropertiesResource(ServiceRegistrarProperties.class);

        EndpointConfigurator.changePathValue(ServiceRegistrarController.class, properties.getRegistrationEndpoint(), REGISTRATION_METHOD_NAME, String.class, String.class, String.class);
        EndpointConfigurator.changePathValue(ServiceRegistrarController.class, properties.getDeregistrationEndpoint(), DEREGISTRATION_METHOD_NAME, String.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.debug("Context destroyed");
    }

}
