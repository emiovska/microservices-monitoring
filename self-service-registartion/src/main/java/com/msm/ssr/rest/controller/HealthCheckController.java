package com.msm.ssr.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author riste.jovanoski
 * @since 6/12/2017
 */
@Path("/")
public class HealthCheckController {

    @GET
    @Path("/app-check")
    public String healthCheck() {
        return "The service self registration application is running";
    }

}
