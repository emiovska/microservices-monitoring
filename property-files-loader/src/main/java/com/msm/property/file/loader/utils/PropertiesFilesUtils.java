package com.msm.property.file.loader.utils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class PropertiesFilesUtils {

    public static Object createPropertiesResourceInstance(Class propertiesClass) throws IllegalAccessException, InstantiationException {
        return propertiesClass.newInstance();
    }

    public static void populateInstanceFieldsValues(Object instance, Map<String,String> fileValues) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(Boolean.TRUE);
            String propertyName = AnnotationUtils.extractPropertyNameForField(field);
            if (fileValues.containsKey(propertyName)) {
                String value = fileValues.get(propertyName);
                field.set(instance, value);
            }
        }
    }

}
