package com.msm.integration.pool.converters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author riste.jovanoski
 * @since 6/21/2017
 */
public class ServiceEntityJsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertToJson(Object object) {
        if (object == null) {
            return null;
        }

        String result = null;
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
