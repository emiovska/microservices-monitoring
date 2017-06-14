package com.msm.ssr.builders;

import com.msm.ssr.exceptions.UrlBuildException;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class UrlPathBuilder {

    public static String buildUrl(String host, String[] actions) throws UrlBuildException {
        if (host == null || actions == null) {
            throw new UrlBuildException("Could not build url! Host and actions must not be null");
        }

        StringBuilder urlBuilder = new StringBuilder();
        if (host.endsWith("/")) {
            host = host.substring(0, (host.length() - 1));
        }
        urlBuilder.append(host);
        for (String action : actions) {
            if (!action.startsWith("/")) {
                urlBuilder.append("/");
            }
            urlBuilder.append(action);
        }
        return urlBuilder.toString();
    }

}
