package com.msm.sr.service.status.notification.listener;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public interface ServiceStatusListener {

    public void notifyForRegistration(String... parameters);

    public void notifyForDeregistration(String... parameters);

}
