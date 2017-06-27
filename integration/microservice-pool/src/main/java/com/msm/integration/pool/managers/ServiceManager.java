package com.msm.integration.pool.managers;

import com.msm.integration.pool.data.service.ServiceEntityService;
import com.msm.integration.pool.data.service.impl.ServiceEntityServiceImpl;
import com.msm.integration.pool.service.state.check.services.HealthCheckService;
import com.msm.integration.pool.service.state.check.services.ServiceStateService;
import com.msm.integration.pool.service.state.check.services.impl.HealthCheckServiceImpl;
import com.msm.integration.pool.service.state.check.services.impl.ServiceStateServiceImpl;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public class ServiceManager {

    private static final ServiceEntityService SERVICE_ENTITY_SERVICE = new ServiceEntityServiceImpl();
    private static final HealthCheckService HEALTH_CHECK_SERVICE = new HealthCheckServiceImpl();
    private static final ServiceStateService SERVICE_STATE_SERVICE = new ServiceStateServiceImpl();

    public static ServiceEntityService getServiceEntityService() {
        return SERVICE_ENTITY_SERVICE;
    }

    public static HealthCheckService getHealthCheckService() {
        return HEALTH_CHECK_SERVICE;
    }

    public static ServiceStateService getServiceStateService() {
        return SERVICE_STATE_SERVICE;
    }

}
