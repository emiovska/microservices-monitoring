package com.msm.sr.rest.actions;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public interface ServiceRegistrarActions {

    int register(String serviceId, String serviceHost, String healthEndpoint);

    int deregister(String serviceId);

}
