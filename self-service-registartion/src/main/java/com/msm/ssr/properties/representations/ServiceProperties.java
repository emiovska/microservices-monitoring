package com.msm.ssr.properties.representations;

import com.msm.property.file.loader.annotations.PropertiesResource;
import com.msm.property.file.loader.annotations.PropertyName;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
@PropertiesResource("service.properties")
public class ServiceProperties {
    @PropertyName("service.id")
    private String id;
    @PropertyName("service.healthcheck.endpoint")
    private String healthCheckEndpoint;
    @PropertyName("service.registration.endpoint")
    private String registrationEndpoint;
    @PropertyName("service.deregisration.endpoint")
    private String deregistrationEndpoint;
    @PropertyName("service.registrar.host")
    private String registrarHost;
    @PropertyName("service.useHostnameOverIP")
    private String useHostnameOverIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHealthCheckEndpoint() {
        return healthCheckEndpoint;
    }

    public void setHealthCheckEndpoint(String healthCheckEndpoint) {
        this.healthCheckEndpoint = healthCheckEndpoint;
    }

    public String getRegistrationEndpoint() {
        return registrationEndpoint;
    }

    public void setRegistrationEndpoint(String registrationEndpoint) {
        this.registrationEndpoint = registrationEndpoint;
    }

    public String getDeregistrationEndpoint() {
        return deregistrationEndpoint;
    }

    public void setDeregistrationEndpoint(String deregistrationEndpoint) {
        this.deregistrationEndpoint = deregistrationEndpoint;
    }

    public String getRegistrarHost() {
        return registrarHost;
    }

    public void setRegistrarHost(String registrarHost) {
        this.registrarHost = registrarHost;
    }

    public String getUseHostnameOverIp() {
        return useHostnameOverIp;
    }

    public void setUseHostnameOverIp(String useHostnameOverIp) {
        this.useHostnameOverIp = useHostnameOverIp;
    }
}
