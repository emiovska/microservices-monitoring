package com.msm.property.file.loader.utils;

import com.msm.property.file.loader.annotations.PropertiesResource;
import com.msm.property.file.loader.annotations.PropertyName;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class AnnotationUtils {

    private static final Reflections reflections = new Reflections();

    @SuppressWarnings("unchecked")
    public static Set<Class<?>> getClassesWithAnnotation(Class annotation) {
        if(annotation == null) {
            return new HashSet<>();
        }
        return reflections.getTypesAnnotatedWith(annotation);
    }

    public static String extractFileName(Class propertiesResource) {
        PropertiesResource resourceAnnotation = (PropertiesResource) propertiesResource.getAnnotation(PropertiesResource.class);
        return resourceAnnotation.value();
    }

    public static String extractPropertyNameForField(Field field) {
        return field.getAnnotation(PropertyName.class).value();
    }

}
