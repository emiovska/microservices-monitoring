package com.msm.endpoint.configurator.utils;

import com.msm.endpoint.configurator.value.overrider.AnnotationValueOverrider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.Path;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author riste.jovanoski
 * @since 6/27/2017
 */
public class PathAnnotationUtils {

    private static final Logger LOGGER = LogManager.getLogger(PathAnnotationUtils.class);

    public static boolean overridePathAnnotationValue(Object instance, String newPathValue) {
        Annotation annotation = getPathAnnotationForObject(instance);
        if (annotation != null && AnnotationValueOverrider.overrideAnnotationValue(annotation, newPathValue)) {
            LOGGER.debug("newPathValue successfully overridden");
            return true;
        }

        LOGGER.debug("could not override newPathValue");
        return false;
    }

    @SuppressWarnings("WeakerAccess")
    public static Annotation getPathAnnotationForObject(Object instance) {
        if (instance instanceof Class) {
            Class resource = (Class) instance;
            return resource.getAnnotation(Path.class);
        }

        if (instance instanceof Method) {
            Method resource = (Method) instance;
            return resource.getAnnotation(Path.class);
        }

        return null;
    }

}
