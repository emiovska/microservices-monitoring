package com.msm.integration.pool.data.service.impl;

import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.integration.pool.data.repository.ServiceEntityRepository;
import com.msm.integration.pool.data.repository.manager.RepositoryManager;
import com.msm.integration.pool.data.service.ServiceEntityService;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public class ServiceEntityServiceImpl implements ServiceEntityService {

    private static final ServiceEntityRepository SERVICE_ENTITY_REPOSITORY = RepositoryManager.getServiceEntityRepository();

    @Override
    public ServiceEntity findById(Long id) {
        return SERVICE_ENTITY_REPOSITORY.findById(id);
    }

    @Override
    public List<ServiceEntity> findAll() {
        return SERVICE_ENTITY_REPOSITORY.list();
    }

    @Override
    public void save(String serviceId, String serviceHost, String healthCheck) {
        SERVICE_ENTITY_REPOSITORY.save(new ServiceEntity(serviceId, serviceHost, healthCheck));
    }

    @Override
    public void update(Long id, String serviceId, String serviceHost, String healthCheck) {
        ServiceEntity serviceEntity = SERVICE_ENTITY_REPOSITORY.findById(id);
        serviceEntity.setServiceId(serviceId);
        serviceEntity.setServiceHost(serviceHost);
        serviceEntity.setHealthCheck(healthCheck);
        SERVICE_ENTITY_REPOSITORY.update(serviceEntity);
    }

    @Override
    public void delete(Long id) {
        SERVICE_ENTITY_REPOSITORY.delete(SERVICE_ENTITY_REPOSITORY.findById(id));
    }
}
