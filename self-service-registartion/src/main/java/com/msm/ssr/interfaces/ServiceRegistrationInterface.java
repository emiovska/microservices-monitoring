package com.msm.ssr.interfaces;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public interface ServiceRegistrationInterface {

    public boolean register(String registerHost, String registrationEndpoint, String serviceId, String serviceHost, String healthCheckEndpoint);

    public boolean deregister(String registerHost, String deregisterEndpoint, String serviceId);
}
