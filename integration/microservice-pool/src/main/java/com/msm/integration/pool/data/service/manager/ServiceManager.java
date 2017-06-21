package com.msm.integration.pool.data.service.manager;

import com.msm.integration.pool.data.service.ServiceEntityService;
import com.msm.integration.pool.data.service.impl.ServiceEntityServiceImpl;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public class ServiceManager {

    private static final ServiceEntityService SERVICE_ENTITY_SERVICE = new ServiceEntityServiceImpl();

    public static ServiceEntityService getServiceEntityService() {
        return SERVICE_ENTITY_SERVICE;
    }

}