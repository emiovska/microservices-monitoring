package com.msm.ssr.interfaces;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
@SuppressWarnings("unused")
public interface ServiceRegistrationInterface {

    boolean register(String registerHost, String registrationEndpoint, String serviceId, String serviceHost, String healthCheckEndpoint);

    boolean deregister(String registerHost, String deregisterEndpoint, String serviceId);
}
