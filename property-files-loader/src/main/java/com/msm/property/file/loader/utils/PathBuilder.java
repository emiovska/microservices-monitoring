package com.msm.property.file.loader.utils;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class PathBuilder {

    public static String buildPathForFile(String fileName) {
        ClassLoader classLoader = PathBuilder.class.getClassLoader();
        return classLoader.getResource(fileName).getFile();
    }

}
