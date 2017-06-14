package com.msm.property.file.loader.service;

import com.msm.property.file.loader.mapper.PropertiesFilesMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class PropertiesFilesService {

    private static Map<Class, Object> resources = new HashMap();

    static {
        resources = PropertiesFilesMapper.mapPropertiesFilesIntoClasses();
    }

    public static <T> T getPropertiesResource(Class<T> clazz) {
        return clazz.cast(resources.get(clazz));
    }

}
