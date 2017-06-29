package com.msm.sr.base;

import com.msm.endpoint.configurator.EndpointConfigurator;
import com.msm.property.file.loader.service.PropertiesFilesService;
import com.msm.sr.properties.ServiceRegistrarProperties;
import com.msm.sr.rest.controllers.ServiceRegistrarController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author elena.miovska
 * @since 6/25/2017
 */
public class ServiceRegistrationDeregistrationEndpointConfigurator {

    private static final ServiceRegistrarProperties properties = PropertiesFilesService.getPropertiesResource(ServiceRegistrarProperties.class);

    public static final String REGISTRATION_METHOD_PATH = "register";
    public static final String DEREGISTRATION_METHOD_PATH = "deregister";

    public static void configureEndpoints() {
        EndpointConfigurator.changePathValue(ServiceRegistrarController.class, properties.getRegistrationEndpoint(), REGISTRATION_METHOD_PATH, HttpServletRequest.class, String.class, String.class, String.class);
        EndpointConfigurator.changePathValue(ServiceRegistrarController.class, properties.getDeregistrationEndpoint(), DEREGISTRATION_METHOD_PATH, String.class);

    }
}
