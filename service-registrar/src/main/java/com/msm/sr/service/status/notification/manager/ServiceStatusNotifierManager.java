package com.msm.sr.service.status.notification.manager;

import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class ServiceStatusNotifierManager {

    private static final ServiceStatusNotifier SERVICE_STATUS_NOTIFIER = new ServiceStatusNotifier();

    public static ServiceStatusNotifier getNotifier() {
        return SERVICE_STATUS_NOTIFIER;
    }

}
