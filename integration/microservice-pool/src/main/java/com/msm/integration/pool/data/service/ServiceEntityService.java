package com.msm.integration.pool.data.service;

import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.sr.service.status.notification.listener.ServiceStatusListener;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public interface ServiceEntityService extends ServiceStatusListener {

    public ServiceEntity findById(Long id);

    public ServiceEntity findByServiceId(String serviceId);

    public List<ServiceEntity> findAll();

    public void save(String serviceId, String serviceHost, String healthCheck);

    public void update(Long id, String serviceId, String serviceHost, String healthCheck);

    public void delete(Long id);

}
