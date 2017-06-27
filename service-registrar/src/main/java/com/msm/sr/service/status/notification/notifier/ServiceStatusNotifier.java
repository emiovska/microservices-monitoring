package com.msm.sr.service.status.notification.notifier;

import com.msm.sr.service.status.notification.listener.ServiceStatusListener;
import com.msm.sr.service.status.notification.type.NotificationType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class ServiceStatusNotifier {

    private static List<ServiceStatusListener> listeners = new ArrayList<>();

    public void registerListener(ServiceStatusListener... listeners) {
        ServiceStatusNotifier.listeners.addAll(Arrays.asList(listeners));
    }

    public void unregisterListener(ServiceStatusListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(NotificationType notificationType, String... parameters) {
        notificationType.notifyForUpdate(this, parameters);
    }

    public void notifyForRegistration(String... parameters) {
        for (ServiceStatusListener listener : listeners) {
            listener.notifyForRegistration(parameters);
        }
    }

    public void notifyForDeregistration(String... parameters) {
        for (ServiceStatusListener listener : listeners) {
            listener.notifyForDeregistration(parameters);
        }
    }

}
