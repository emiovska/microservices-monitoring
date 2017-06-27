package com.msm.sr.service.status.notification;

import com.msm.sr.service.status.notification.listener.ServiceStatusListener;

/**
 * Created by elena.miovska on 25.6.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class TestListener implements ServiceStatusListener {

    public static String RECEIVED_REGISTRATION_MESSAGE;
    public static String RECEIVED_DEREGISTRATION_MESSAGE;

    @Override
    public void notifyForRegistration(String... parameters) {
        RECEIVED_REGISTRATION_MESSAGE = parameters[0];
    }

    @Override
    public void notifyForDeregistration(String... parameters) {
        RECEIVED_DEREGISTRATION_MESSAGE = parameters[0];
    }
}
