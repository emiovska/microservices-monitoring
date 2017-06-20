package com.msm.sr.interfaces;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public interface ServiceRegistrarActions {

    public String register(String serviceId, String serviceHost, String healthEndpoint);

    public String deregister(String serviceId);

}
