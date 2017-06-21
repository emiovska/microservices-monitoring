package com.msm.integration.pool.data.service.manager;

import com.msm.integration.pool.data.service.ServiceEntityService;
import com.msm.integration.pool.data.service.impl.ServiceEntityServiceImpl;
import com.msm.sr.service.status.notification.manager.ServiceStatusNotifierManager;
import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public class ServiceManager {

    private static final ServiceStatusNotifier NOTIFIER = ServiceStatusNotifierManager.getNotifier();
    private static final ServiceEntityService SERVICE_ENTITY_SERVICE = new ServiceEntityServiceImpl();

    public static void initializeListeners() {
        NOTIFIER.registerListener(SERVICE_ENTITY_SERVICE);
    }

    public static ServiceEntityService getServiceEntityService() {
        return SERVICE_ENTITY_SERVICE;
    }

}
