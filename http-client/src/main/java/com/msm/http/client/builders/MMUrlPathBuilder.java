package com.msm.http.client.builders;

import com.msm.http.client.exceptions.MMUrlBuildException;

/**
 * @author riste.jovanoski
 * @since 6/21/2017
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class MMUrlPathBuilder {

    public static String buildUrl(String host, String[] actions) throws MMUrlBuildException {
        if (host == null || actions == null) {
            throw new MMUrlBuildException("Could not build url! Host and actions must not be null");
        }

        if (!host.startsWith("http")) {
            host = String.format("http://%s", host);
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
