package com.msm.ssr.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.Path;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class PathAnnotationUtils {

    private static final Logger LOGGER = LogManager.getLogger(PathAnnotationUtils.class);

    public static boolean changePathValue(Class resourceClass, String newPathValue) {
        newPathValue = normalizeNewPathValue(newPathValue);
        Annotation annotation = resourceClass.getAnnotation(Path.class);
        if (AnnotationValueUtils.overrideAnnotationValue(annotation, newPathValue)) {
            LOGGER.debug("newPathValue successfully overridden");
            return true;
        }

        LOGGER.debug("could not override newPathValue");
        return false;
    }

    public static boolean changePathValue(Class resource, String methodName, String newPathValue) {
        Method method = null;
        try {
            method = resource.getMethod(methodName);
            Annotation annotation = method.getAnnotation(Path.class);
            if (AnnotationValueUtils.overrideAnnotationValue(annotation, newPathValue)) {
                LOGGER.debug("newPathValue successfully overridden");
                return true;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        LOGGER.debug("could not override newPathValue");
        return false;
    }

    private static String normalizeNewPathValue(String path) {
        if (path.startsWith("/")) {
            return path.substring(1, path.length());
        }
        return path;
    }

}
