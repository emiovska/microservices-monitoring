package com.msm.property.file.loader.utils;

import java.net.URL;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class PathBuilder {

    public static String buildPathForFile(String fileName) {
        ClassLoader classLoader = PathBuilder.class.getClassLoader();
        URL url = classLoader.getResource(fileName);

        if (url != null) {
            return url.getFile();
        }

        return fileName;
    }

}
