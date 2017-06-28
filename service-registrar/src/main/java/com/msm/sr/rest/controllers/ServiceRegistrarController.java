package com.msm.sr.rest.controllers;

import com.msm.sr.rest.actions.ServiceRegistrarActions;
import com.msm.sr.service.status.notification.manager.ServiceStatusNotifierManager;
import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;
import com.msm.sr.service.status.notification.type.NotificationType;
import com.msm.sr.utils.ServiceServerUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Enumeration;

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
    public int register(@Context HttpServletRequest request, @FormParam(SERVICE_ID_PARAMETER_NAME) String serviceId, @FormParam(SERVICE_HOST_PARAMETER_NAME) String serviceHost, @FormParam(SERVICE_HEALTH_CHECK_PARAMETER_NAME) String healthEndpoint) {
        serviceStatusNotifier.notifyListeners(NotificationType.REGISTRATION, serviceId, serviceHost, healthEndpoint, ServiceServerUtils.getClientIpAddress(request));
        return Response.Status.OK.getStatusCode();
    }

    @GET
    @Path(DEREGISTRATION_METHOD_PATH)
    public int deregister(@QueryParam(SERVICE_ID_PARAMETER_NAME) String serviceId) {
        serviceStatusNotifier.notifyListeners(NotificationType.DEREGISTRATION, serviceId);
        return Response.Status.OK.getStatusCode();
    }

}
