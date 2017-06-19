package com.msm.endpoint.configurator.utils;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class PathUtils {

    public static String normalizeNewPathValue(String path) {
        if (path.startsWith("/")) {
            return path.substring(1, path.length());
        }
        return path;
    }

}
