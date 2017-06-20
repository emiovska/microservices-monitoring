package com.msm.endpoint.configurator;

import com.msm.endpoint.configurator.utils.PathUtils;
import com.msm.endpoint.configurator.value.overrider.AnnotationValueOverrider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.Path;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class EndpointConfigurator {

    private static final Logger LOGGER = LogManager.getLogger(EndpointConfigurator.class);

    public static boolean changePathValue(Class resourceClass, String newPathValue) {
        newPathValue = PathUtils.normalizeNewPathValue(newPathValue);
        Annotation annotation = resourceClass.getAnnotation(Path.class);
        if (AnnotationValueOverrider.overrideAnnotationValue(annotation, newPathValue)) {
            LOGGER.debug("newPathValue successfully overridden");
            return true;
        }

        LOGGER.debug("could not override newPathValue");
        return false;
    }

    public static boolean changePathValue(Class resource, String newPathValue, String methodName, Class<?>... parametersTypes) {
        newPathValue = PathUtils.normalizeNewPathValue(newPathValue);
        Method method = null;
        try {
            method = resource.getMethod(methodName, parametersTypes);
            Annotation annotation = method.getAnnotation(Path.class);
            if (AnnotationValueOverrider.overrideAnnotationValue(annotation, newPathValue)) {
                LOGGER.debug("newPathValue successfully overridden");
                return true;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        LOGGER.debug("could not override newPathValue");
        return false;
    }

}
