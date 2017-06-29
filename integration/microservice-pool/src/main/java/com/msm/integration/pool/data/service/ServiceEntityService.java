package com.msm.integration.pool.data.service;

import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.sr.service.status.notification.listener.ServiceStatusListener;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
@SuppressWarnings("SameParameterValue")
public interface ServiceEntityService extends ServiceStatusListener {

    ServiceEntity findById(Long id);

    ServiceEntity findByServiceId(String serviceId);

    List<ServiceEntity> findAll();

    void save(String serviceId, String serviceHost, String secondaryServiceHost, String healthCheck);

    void update(Long id, String serviceId, String serviceHost, String secondaryServiceHost, String healthCheck);

    void delete(Long id);

}
