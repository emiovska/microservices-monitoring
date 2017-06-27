package com.msm.integration.pool.listeners;

import com.msm.integration.pool.data.hibernate.utils.HibernateUtils;
import com.msm.integration.pool.managers.ServiceManager;
import com.msm.integration.pool.service.state.check.services.ServiceStateService;
import com.msm.sr.service.status.notification.manager.ServiceStatusNotifierManager;
import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public class PoolContextListener implements ServletContextListener {

    private static final ServiceStatusNotifier NOTIFIER = ServiceStatusNotifierManager.getNotifier();
    private static final ServiceStateService SERVICE_STATE_SERVICE = ServiceManager.getServiceStateService();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServiceStatusChangesListener serviceStatusChangesListener = new ServiceStatusChangesListener();
        NOTIFIER.registerListener(serviceStatusChangesListener);
        NOTIFIER.registerListener(ServiceManager.getServiceEntityService());
        SERVICE_STATE_SERVICE.checkServicesState();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        HibernateUtils.shutdown();
    }
}
