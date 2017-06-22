package com.msm.sr.rest.controllers;

import com.msm.integration.pool.utils.SwaggerFileReader;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author riste.jovanoski
 * @since 6/22/2017
 */
@Path("/swagger")
public class SwaggerController {

    @GET
    public Viewable index() {
        return new Viewable("/swagger/index.jsp");
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String swagger() {
        return SwaggerFileReader.readSwaggerFile();
    }

}
