package com.msm.integration.pool.service.state.check.services.impl;

import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.integration.pool.data.service.ServiceEntityService;
import com.msm.integration.pool.managers.ServiceManager;
import com.msm.integration.pool.service.state.check.services.HealthCheckService;
import com.msm.integration.pool.service.state.check.services.ServiceStateService;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/21/2017
 */
public class ServiceStateServiceImpl implements ServiceStateService {

    private static final ServiceEntityService SERVICE_ENTITY_SERVICE = ServiceManager.getServiceEntityService();
    private static final HealthCheckService HEALTH_CHECK_SERVICE = ServiceManager.getHealthCheckService();

    @Override
    public void checkServicesState() {
        List<ServiceEntity> registeredServices = SERVICE_ENTITY_SERVICE.findAll();
        for (ServiceEntity registeredService : registeredServices) {
            if (!HEALTH_CHECK_SERVICE.isServiceActive(registeredService)) {
                removeNotActiveServiceFromDatabase(registeredService);
            }
        }
    }

    private void removeNotActiveServiceFromDatabase(ServiceEntity serviceEntity) {
        SERVICE_ENTITY_SERVICE.delete(serviceEntity.getId());
    }
}