package com.msm.integration.pool.data.service;

import com.msm.integration.pool.data.model.ServiceEntity;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public interface ServiceEntityService {

    public ServiceEntity findById(Long id);

    public List<ServiceEntity> findAll();

    public void save(String serviceId, String serviceHost, String healthCheck);

    public void update(Long id, String serviceId, String serviceHost, String healthCheck);

    public void delete(Long id);

}
