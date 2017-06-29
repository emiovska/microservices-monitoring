package com.msm.sr.request.header.names;

/**
 * @author riste.jovanoski
 * @since 6/28/2017
 */
public interface HeaderNames {
    String X_FORWARDED_FOR = "X-Forwarded-For";
    String PROXY_CLIENT_IP = "Proxy-Client-IP";
    String WL_PROXY_CL_ENT_IP = "WL-Proxy-Client-IP";
    String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";
    String HTTP_X_FORWARDED = "HTTP_X_FORWARDED";
    String HTTP_X_CLUSTER_CLIENT_IP = "HTTP_X_CLUSTER_CLIENT_IP";
    String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    String HTTP_FORWARDED_FOR = "HTTP_FORWARDED_FOR";
    String HTTP_FORWARDED = "HTTP_FORWARDED";
    String HTTP_VIA = "HTTP_VIA";
    String REMOTE_ADDR = "REMOTE_ADDR";
}
