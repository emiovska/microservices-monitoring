package com.msm.property.file.loader.utils;

import java.io.File;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class PathBuilder {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String SEPARATOR = File.separator;

    public static String buildRootPath(String[] parts) {
        StringBuilder sb = new StringBuilder(USER_DIR);
        if (parts != null) {
            sb.append(buildRelativePath(parts));
        }
        return sb.toString();
    }

    public static String buildRelativePath(String[] parts) {
        StringBuilder sb = new StringBuilder(SEPARATOR);
        if (parts != null) {
            for (int i = 0; i < parts.length; i++) {
                sb.append(parts[i].trim());
                if (i != (parts.length - 1)) {
                    sb.append(SEPARATOR);
                }
            }
        }
        return sb.toString();
    }

}
