package com.msm.ssr.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author riste.jovanoski
 * @since 6/12/2017
 */
@Path("/")
public class HealthCheckController {

    @GET
    @Path("/app-check")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthCheck() {
        return "The service self registration application is running";
    }

}
