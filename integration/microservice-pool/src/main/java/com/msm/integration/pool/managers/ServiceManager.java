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

    private static final ServiceStatusNotifier serviceStatusNotifier = ServiceStatusNotifierManager.getNotifier();
    private static final ServiceEntityService serviceEntityService = new ServiceEntityServiceImpl();
    private static final HealthCheckService healthCheckService = new HealthCheckServiceImpl();
    private static final ServiceStateService serviceStateService = new ServiceStateServiceImpl();

    public static ServiceEntityService getServiceEntityService() {
        return serviceEntityService;
    }

    public static HealthCheckService getHealthCheckService() {
        return healthCheckService;
    }

    public static ServiceStateService getServiceStateService() {
        return serviceStateService;
    }

}
