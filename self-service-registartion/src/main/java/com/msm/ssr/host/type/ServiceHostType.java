package com.msm.ssr.host.type;

import com.msm.ssr.exceptions.ApplicationServerUrlException;
import com.msm.ssr.utils.ServerUtils;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/16/2017
 */
public enum ServiceHostType {
    IP, HOSTNAME;

    private int value;

    static {
        IP.value = 0;
        HOSTNAME.value = 1;
    }

    public String getServiceAddress(String contextPath) throws ApplicationServerUrlException {
        List<String> urls = ServerUtils.getServerUrl(contextPath);
        return urls.get(value);
    }

}
