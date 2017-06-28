package com.msm.sr.rest.actions;

import javax.servlet.http.HttpServletRequest;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
@SuppressWarnings("unused")
public interface ServiceRegistrarActions {

    int register(HttpServletRequest request, String serviceId, String serviceHost, String healthEndpoint);

    int deregister(String serviceId);

}
