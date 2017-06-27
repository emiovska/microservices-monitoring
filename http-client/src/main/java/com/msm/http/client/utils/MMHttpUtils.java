package com.msm.http.client.utils;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/16/2017
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class MMHttpUtils {

    public static Map<String, String> constructParametersMap(String[] names, String[] values) {
        if (names.length != values.length) {
            throw new InvalidParameterException("Name and values sizes must be equal");
        }

        HashMap<String, String> parameters = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            parameters.put(names[i], values[i]);
        }

        return parameters;
    }

}
