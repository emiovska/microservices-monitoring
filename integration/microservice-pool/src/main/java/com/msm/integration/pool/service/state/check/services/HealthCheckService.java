package com.msm.integration.pool.service.state.check.services;

import com.msm.integration.pool.data.model.ServiceEntity;

/**
 * @author riste.jovanoski
 * @since 6/21/2017
 */
public interface HealthCheckService {

    public boolean isServiceActive(ServiceEntity serviceEntity);

}
