package com.msm.sr.service.status.notification.type;

import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public enum NotificationType {
    REGISTRATION {
        @Override
        public void notifyForUpdate(ServiceStatusNotifier serviceStatusNotifier, String... parameters) {
            serviceStatusNotifier.notifyForRegistration(parameters);
        }
    },
    DEREGISTRATION {
        @Override
        public void notifyForUpdate(ServiceStatusNotifier serviceStatusNotifier, String... parameters) {
            serviceStatusNotifier.notifyForDeregistration(parameters);
        }
    };

    public abstract void notifyForUpdate(ServiceStatusNotifier serviceStatusNotifier, String... parameters);
}
