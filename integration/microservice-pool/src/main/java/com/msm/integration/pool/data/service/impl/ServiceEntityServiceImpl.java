package com.msm.integration.pool.data.service.impl;

import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.integration.pool.data.repository.ServiceEntityRepository;
import com.msm.integration.pool.managers.RepositoryManager;
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
    public ServiceEntity findByServiceId(String serviceId) {
        return SERVICE_ENTITY_REPOSITORY.findByServiceId(serviceId);
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

    @Override
    public void notifyForRegistration(String... parameters) {
        String serviceId = parameters[0];
        if (!checkIfServiceWithServiceIdExists(serviceId)) {
            SERVICE_ENTITY_REPOSITORY.save(new ServiceEntity(serviceId, parameters[1], parameters[2]));
        }
    }

    @Override
    public void notifyForDeregistration(String... parameters) {
        SERVICE_ENTITY_REPOSITORY.delete(SERVICE_ENTITY_REPOSITORY.findByServiceId(parameters[0]));
    }

    private boolean checkIfServiceWithServiceIdExists(String serviceId) {
        ServiceEntity serviceEntity = SERVICE_ENTITY_REPOSITORY.findByServiceId(serviceId);
        return serviceEntity != null;
    }

}
