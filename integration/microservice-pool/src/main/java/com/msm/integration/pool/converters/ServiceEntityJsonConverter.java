package com.msm.integration.pool.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msm.integration.pool.data.model.ServiceEntity;

import java.io.IOException;
import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/21/2017
 */
public class ServiceEntityJsonConverter {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String convertServiceEntityToJson(ServiceEntity serviceEntity) {
        if (serviceEntity == null) {
            return null;
        }

        String result = null;
        try {
            result = OBJECT_MAPPER.writeValueAsString(serviceEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String convertServiceEntitiesListToJson(List<ServiceEntity> serviceEntities) {
        if (serviceEntities == null) {
            return null;
        }
        String result = null;
        try {
            result = OBJECT_MAPPER.writeValueAsString(serviceEntities);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
