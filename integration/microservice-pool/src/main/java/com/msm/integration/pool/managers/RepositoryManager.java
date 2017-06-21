package com.msm.integration.pool.managers;

import com.msm.integration.pool.data.repository.ServiceEntityRepository;
import com.msm.integration.pool.data.repository.impl.ServiceEntityRepositoryImpl;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public class RepositoryManager {

    private static final ServiceEntityRepository SERVICE_ENTITY_REPOSITORY = new ServiceEntityRepositoryImpl();

    public static ServiceEntityRepository getServiceEntityRepository() {
        return SERVICE_ENTITY_REPOSITORY;
    }

}
