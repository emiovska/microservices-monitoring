package com.msm.sr.rest.controllers;

import com.msm.sr.interfaces.ServiceRegistrarActions;
import com.msm.sr.service.status.notification.manager.ServiceStatusNotifierManager;
import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;
import com.msm.sr.service.status.notification.type.NotificationType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */

@Path("/")
public class ServiceRegistrarController implements ServiceRegistrarActions {
    private static final String SERVICE_ID_PARAMETER_NAME = "serviceId";
    private static final String SERVICE_HOST_PARAMETER_NAME = "serviceHost";
    private static final String SERVICE_HEALTH_CHECK_PARAMETER_NAME = "healthCheckEndpoint";
    private static final ServiceStatusNotifier SERVICE_STATUS_NOTIFIER = ServiceStatusNotifierManager.getNotifier();

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    public String register(@FormParam(SERVICE_ID_PARAMETER_NAME) String serviceId, @FormParam(SERVICE_HOST_PARAMETER_NAME) String serviceHost, @FormParam(SERVICE_HEALTH_CHECK_PARAMETER_NAME) String healthEndpoint) {
        SERVICE_STATUS_NOTIFIER.notifyListeners(NotificationType.REGISTRATION, serviceId, serviceHost, healthEndpoint);
        return "register";
    }

    @GET
    @Path("/deregister")
    @Produces(MediaType.TEXT_PLAIN)
    public String deregister(@PathParam(SERVICE_ID_PARAMETER_NAME) String serviceId) {
        SERVICE_STATUS_NOTIFIER.notifyListeners(NotificationType.DEREGISTRATION, serviceId);
        return "deregister";
    }

}
