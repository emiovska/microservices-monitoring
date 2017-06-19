package com.msm.sr.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
@Path("/")
public class MainController {

    @GET
    @Path("/active-services")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllActiveServices() {
        return "[]";
    }

    @GET
    @Path("/active-services/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getActiveService(@PathParam("id") Integer id) {
        return "[]";
    }

}
