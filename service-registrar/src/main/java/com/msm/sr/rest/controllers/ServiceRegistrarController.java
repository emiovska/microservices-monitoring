package com.msm.sr.rest.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */

@Path("/")
public class ServiceRegistrarController {
    private static final String SERVICE_ID_PARAMETER_NAME = "serviceId";
    private static final String SERVICE_HOST_PARAMETER_NAME = "serviceHost";
    private static final String SERVICE_HEALTH_CHECK_PARAMETER_NAME = "healthCheckEndpoint";

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    public String register(@QueryParam(SERVICE_ID_PARAMETER_NAME) String serviceId, @QueryParam(SERVICE_HOST_PARAMETER_NAME) String serviceHost, @QueryParam(SERVICE_HEALTH_CHECK_PARAMETER_NAME) String healthEndpoint) {
        return "register";
    }

    @GET
    @Path("/deregister")
    @Produces(MediaType.TEXT_PLAIN)
    public String deregister(@QueryParam(SERVICE_ID_PARAMETER_NAME) String serviceId) {
        return "deregister";
    }

}
