package com.msm.property.file.loader.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyName {
    String value();
}
