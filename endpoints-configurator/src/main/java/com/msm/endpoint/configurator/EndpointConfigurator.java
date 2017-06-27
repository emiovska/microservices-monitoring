package com.msm.endpoint.configurator;

import com.msm.endpoint.configurator.utils.PathAnnotationUtils;
import com.msm.endpoint.configurator.utils.PathUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class EndpointConfigurator {

    private static final Logger LOGGER = LogManager.getLogger(EndpointConfigurator.class);

    public static boolean changePathValue(Class resourceClass, String newPathValue) {
        newPathValue = PathUtils.normalizeNewPathValue(newPathValue);
        return PathAnnotationUtils.overridePathAnnotationValue(resourceClass, newPathValue);
    }

    @SuppressWarnings("unchecked")
    public static boolean changePathValue(Class resource, String newPathValue, String methodName, Class<?>... parametersTypes) {
        newPathValue = PathUtils.normalizeNewPathValue(newPathValue);
        Method method;
        try {
            method = resource.getMethod(methodName, parametersTypes);
            return PathAnnotationUtils.overridePathAnnotationValue(method, newPathValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        LOGGER.debug("could not override newPathValue");
        return false;
    }

}
