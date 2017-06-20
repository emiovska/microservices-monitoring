package com.msm.sr;

import com.msm.sr.service.status.notification.demo.DemoListener;
import com.msm.sr.service.status.notification.manager.ServiceStatusNotifierManager;
import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;
import com.msm.sr.service.status.notification.type.NotificationType;
import org.junit.Test;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class NotifierTest {

    private static final ServiceStatusNotifier SERVICE_STATUS_NOTIFIER = ServiceStatusNotifierManager.getNotifier();

    @Test
    public void testNotifier() {
        DemoListener listener = new DemoListener();
        DemoListener listener2 = new DemoListener();
        DemoListener listener3 = new DemoListener();

        SERVICE_STATUS_NOTIFIER.registerListener(listener, listener2, listener3);

        SERVICE_STATUS_NOTIFIER.notifyListeners(NotificationType.REGISTRATION);
        SERVICE_STATUS_NOTIFIER.notifyListeners(NotificationType.DEREGISTRATION);
    }

}
