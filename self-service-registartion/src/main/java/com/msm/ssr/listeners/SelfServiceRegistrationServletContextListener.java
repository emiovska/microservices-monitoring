package com.msm.ssr.listeners;

import com.msm.endpoint.configurator.EndpointConfigurator;
import com.msm.property.file.loader.service.PropertiesFilesService;
import com.msm.ssr.exceptions.ApplicationServerUrlException;
import com.msm.ssr.properties.representations.ServiceProperties;
import com.msm.ssr.rest.controller.HealthCheckController;
import com.msm.ssr.server.url.extractor.ServerUrlExtractor;
import com.msm.ssr.server.url.extractor.managers.ExtractorManager;
import com.msm.ssr.services.ServiceRegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class SelfServiceRegistrationServletContextListener implements ServletContextListener {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private static final String HEALTH_CHECK_METHOD_NAME = "healthCheck";
    private static final ServiceRegistrationService serviceRegistrationService = new ServiceRegistrationService();
    private static final ServerUrlExtractor serverUrlExtractor = ExtractorManager.getServerUrlExtractor();

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextInitialized");
        try {
            String serviceRunningAddress = serverUrlExtractor.extractServerUrl(servletContextEvent.getServletContext().getContextPath());

            ServiceProperties serviceProperties = PropertiesFilesService.getPropertiesResource(ServiceProperties.class);
            String healthCheckEndpoint = serviceProperties.getHealthCheckEndpoint();
            EndpointConfigurator.changePathValue(HealthCheckController.class, healthCheckEndpoint, HEALTH_CHECK_METHOD_NAME);

            serviceRegistrationService.register(serviceProperties.getRegistrarHost(), serviceProperties.getRegistrationEndpoint(), serviceProperties.getId(), serviceRunningAddress, healthCheckEndpoint);
        } catch (ApplicationServerUrlException e) {
            e.printStackTrace();
            LOGGER.debug("Could not construct the server urls");
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.debug("contextDestroyed");
        ServiceProperties serviceProperties = PropertiesFilesService.getPropertiesResource(ServiceProperties.class);
        serviceRegistrationService.deregister(serviceProperties.getRegistrarHost(), serviceProperties.getDeregistrationEndpoint(), serviceProperties.getId());
    }
}
