package com.msm.sr.rest.controllers;

import com.msm.sr.rest.actions.ServiceRegistrarActions;
import com.msm.sr.service.status.notification.manager.ServiceStatusNotifierManager;
import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;
import com.msm.sr.service.status.notification.type.NotificationType;

import javax.ws.rs.*;

import static com.msm.sr.base.ServiceRegistrationDeregistrationEndpointConfigurator.DEREGISTRATION_METHOD_PATH;
import static com.msm.sr.base.ServiceRegistrationDeregistrationEndpointConfigurator.REGISTRATION_METHOD_PATH;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */

@Path("/")
public class ServiceRegistrarController implements ServiceRegistrarActions {
    private static final String SERVICE_ID_PARAMETER_NAME = "serviceId";
    private static final String SERVICE_HOST_PARAMETER_NAME = "serviceHost";
    private static final String SERVICE_HEALTH_CHECK_PARAMETER_NAME = "healthCheckEndpoint";
    private static final ServiceStatusNotifier serviceStatusNotifier = ServiceStatusNotifierManager.getNotifier();

    @POST
    @Path(REGISTRATION_METHOD_PATH)
    public void register(@FormParam(SERVICE_ID_PARAMETER_NAME) String serviceId, @FormParam(SERVICE_HOST_PARAMETER_NAME) String serviceHost, @FormParam(SERVICE_HEALTH_CHECK_PARAMETER_NAME) String healthEndpoint) {
        serviceStatusNotifier.notifyListeners(NotificationType.REGISTRATION, serviceId, serviceHost, healthEndpoint);
    }

    @GET
    @Path(DEREGISTRATION_METHOD_PATH)
    public void deregister(@PathParam(SERVICE_ID_PARAMETER_NAME) String serviceId) {
        serviceStatusNotifier.notifyListeners(NotificationType.DEREGISTRATION, serviceId);
    }

}
