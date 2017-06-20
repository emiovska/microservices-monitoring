package com.msm.integration.pool.listeners;

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

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServiceStatusChangesListener serviceStatusChangesListener = new ServiceStatusChangesListener();
        NOTIFIER.registerListener(serviceStatusChangesListener);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
