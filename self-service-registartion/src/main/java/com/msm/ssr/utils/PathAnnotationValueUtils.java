package com.msm.ssr.utils;

import javax.ws.rs.Path;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class PathAnnotationValueUtils {

    public static boolean adaptRootPath(Class resourceClass, String path) {
        path = normalizeNewPath(path);
        Annotation annotation = resourceClass.getAnnotation(Path.class);
        return AnnotationValueUtils.overrideAnnotationValue(annotation, path);
    }

    public static boolean adaptMethodPath(Class resource, String methodName, String path) {
        Method method = null;
        try {
            method = resource.getMethod(methodName);
            Annotation annotation = method.getAnnotation(Path.class);
            return AnnotationValueUtils.overrideAnnotationValue(annotation, path);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String normalizeNewPath(String path) {
        if (path.startsWith("/")) {
            return path.substring(1, path.length());
        }
        return path;
    }

}
