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

    private static List<ServiceStatusListener> LISTENERS = new ArrayList<>();

    public void registerListener(ServiceStatusListener... listeners) {
        LISTENERS.addAll(Arrays.asList(listeners));
    }

    public void unregisterListener() {
        LISTENERS.clear();
    }

    public void notifyListeners(NotificationType notificationType, String... parameters) {
        switch (notificationType) {
            case REGISTRATION:
                notifyForRegistration(parameters);
                break;
            case DEREGISTRATION:
                notifyForDeregistration(parameters);
                break;
            default:
                break;
        }
    }

    private void notifyForRegistration(String... parameters) {
        for (ServiceStatusListener listener : LISTENERS) {
            listener.notifyForRegistration(parameters);
        }
    }

    private void notifyForDeregistration(String... parameters) {
        for (ServiceStatusListener listener : LISTENERS) {
            listener.notifyForDeregistration(parameters);
        }
    }

}
