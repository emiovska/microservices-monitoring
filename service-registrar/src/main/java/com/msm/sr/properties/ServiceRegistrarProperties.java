package com.msm.sr.properties;

import com.msm.property.file.loader.annotations.PropertiesResource;
import com.msm.property.file.loader.annotations.PropertyName;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
@PropertiesResource("service.registrar.properties")
public class ServiceRegistrarProperties {

    @PropertyName("registration.endpoint")
    private String registrationEndpoint;
    
    @PropertyName("deregistration.endpoint")
    private String deregistrationEndpoint;

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
}
