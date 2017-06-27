package com.msm.sr.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
@Path("/")
public class HealthCheckController {

    @SuppressWarnings("SameReturnValue")
    @GET
    @Path("/app-check")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthCheck() {
        return "The service registrar application is running";
    }

}
