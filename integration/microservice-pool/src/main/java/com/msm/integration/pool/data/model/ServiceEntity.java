package com.msm.integration.pool.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
@Entity
@Table(name = "service_entity")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Long id;

    @NotNull
    @Column(name = "service_id", unique = true)
    private String serviceId;

    @NotNull
    @Column(name = "service_host")
    private String serviceHost;

    @NotNull
    @Column(name = "health_check")
    private String healthCheck;

    public ServiceEntity() {
    }

    public ServiceEntity(String serviceId, String serviceHost, String healthCheck) {
        this.serviceId = serviceId;
        this.serviceHost = serviceHost;
        this.healthCheck = healthCheck;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceHost() {
        return serviceHost;
    }

    public void setServiceHost(String serviceHost) {
        this.serviceHost = serviceHost;
    }

    public String getHealthCheck() {
        return healthCheck;
    }

    public void setHealthCheck(String healthCheck) {
        this.healthCheck = healthCheck;
    }

    @Override
    public String toString() {
        return String.format("%d: %s - %s - %s", this.id, this.serviceId, this.serviceHost, this.healthCheck);
    }
}
