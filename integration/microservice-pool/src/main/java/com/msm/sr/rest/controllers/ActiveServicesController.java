package com.msm.sr.rest.controllers;

import com.msm.integration.pool.converters.ServiceEntityJsonConverter;
import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.integration.pool.data.service.ServiceEntityService;
import com.msm.integration.pool.managers.ServiceManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
@Api(value = "/", description = "Service for active services registered to the service register", tags = {"Active Services Controller"})
public class ActiveServicesController {

    private final ServiceEntityService serviceEntityService = ServiceManager.getServiceEntityService();

    @GET
    @Path("/active-services")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "List all active services", response = ServiceEntity.class, responseContainer = "List")
    public String getActiveServices() {
        List<ServiceEntity> serviceEntities = serviceEntityService.findAll();
        return ServiceEntityJsonConverter.convertToJson(serviceEntities);
    }

    @GET
    @Path("/active-services/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get an active service by database id", response = ServiceEntity.class)
    public String getActiveService(@ApiParam(value = "Database id", required = true) @PathParam("id") Long id) {
        ServiceEntity serviceEntity = serviceEntityService.findById(id);
        return ServiceEntityJsonConverter.convertToJson(serviceEntity);
    }

    @GET
    @Path("/active-services/name/{serviceId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get an active service by serviceId", response = ServiceEntity.class)
    public String getActiveServiceByServiceId(@ApiParam(value = "ServiceId from the properties file", required = true) @PathParam("serviceId") String serviceId) {
        ServiceEntity serviceEntity = serviceEntityService.findByServiceId(serviceId);
        return ServiceEntityJsonConverter.convertToJson(serviceEntity);
    }

}
