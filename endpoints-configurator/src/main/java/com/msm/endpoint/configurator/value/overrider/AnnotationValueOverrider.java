package com.msm.endpoint.configurator.value.overrider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class AnnotationValueOverrider {
    private static final String ANNOTATION_VALUE_PROPERTY_NAME = "value";
    private static final String FIELD_PROPERTY_NAME = "memberValues";

    @SuppressWarnings("unchecked")
    public static boolean overrideAnnotationValue(Annotation annotation, String newValue) {
        Object handler = Proxy.getInvocationHandler(annotation);
        Field field;
        try {
            field = handler.getClass().getDeclaredField(FIELD_PROPERTY_NAME);
        } catch (NoSuchFieldException exception) {
            exception.printStackTrace();
            return false;
        }
        field.setAccessible(true);
        Map<String, String> memberValues;
        try {
            memberValues = (Map<String, String>) field.get(handler);
        } catch (IllegalAccessException exception) {
            exception.printStackTrace();
            return false;
        }
        Object oldValue = memberValues.get(ANNOTATION_VALUE_PROPERTY_NAME);
        if (oldValue == null || oldValue.getClass() != newValue.getClass()) {
            return false;
        }
        memberValues.put(ANNOTATION_VALUE_PROPERTY_NAME, newValue);
        return true;
    }
}
