package com.msm.sr.service.status.notification;

import com.msm.sr.service.status.notification.manager.ServiceStatusNotifierManager;
import com.msm.sr.service.status.notification.notifier.ServiceStatusNotifier;
import org.junit.Assert;
import org.junit.Test;

import static com.msm.sr.service.status.notification.TestListener.RECEIVED_DEREGISTRATION_MESSAGE;
import static com.msm.sr.service.status.notification.TestListener.RECEIVED_REGISTRATION_MESSAGE;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class NotifierTest {

    private static final ServiceStatusNotifier serviceStatusNotifier = ServiceStatusNotifierManager.getNotifier();

    @Test
    public void testNotifier() {
        String expectedRegistrationMessage = "This is registration message";
        String expectedDeregistrationMessage = "This is deregistration message";

        TestListener testListener = new TestListener();
        serviceStatusNotifier.registerListener(testListener);

        //test received message on registration
        testListener.notifyForRegistration(expectedRegistrationMessage);
        Assert.assertEquals(RECEIVED_REGISTRATION_MESSAGE, expectedRegistrationMessage);

        //test received message on deregistration
        testListener.notifyForDeregistration(expectedDeregistrationMessage);
        Assert.assertEquals(RECEIVED_DEREGISTRATION_MESSAGE, expectedDeregistrationMessage);


    }

}
