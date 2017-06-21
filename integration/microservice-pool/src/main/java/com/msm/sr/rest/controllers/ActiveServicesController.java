package com.msm.sr.rest.controllers;

import com.msm.integration.pool.converters.ServiceEntityJsonConverter;
import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.integration.pool.data.service.ServiceEntityService;
import com.msm.integration.pool.managers.ServiceManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/21/2017
 */
@Path("/")
public class ActiveServicesController {

    private final ServiceEntityService SERVICE_ENTITY_SERVICE = ServiceManager.getServiceEntityService();

    @GET
    @Path("/active-services")
    @Produces(MediaType.APPLICATION_JSON)
    public String getActiveServices() {
        List<ServiceEntity> serviceEntities = SERVICE_ENTITY_SERVICE.findAll();
        return ServiceEntityJsonConverter.convertServiceEntitiesListToJson(serviceEntities);
    }

    @GET
    @Path("/active-services/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getActiveService(@PathParam("id") Long id) {
        ServiceEntity serviceEntity = SERVICE_ENTITY_SERVICE.findById(id);
        return ServiceEntityJsonConverter.convertServiceEntityToJson(serviceEntity);
    }

    @GET
    @Path("/active-services/name/{serviceId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getActiveServiceByServiceId(@PathParam("serviceId") String serviceId) {
        ServiceEntity serviceEntity = SERVICE_ENTITY_SERVICE.findByServiceId(serviceId);
        return ServiceEntityJsonConverter.convertServiceEntityToJson(serviceEntity);
    }

}
