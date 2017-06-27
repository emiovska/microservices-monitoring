package com.msm.ssr.services;

import com.msm.http.client.MMHttpClient;
import com.msm.http.client.builders.MMUrlPathBuilder;
import com.msm.http.client.exceptions.MMUrlBuildException;
import com.msm.http.client.response.MMHttpResponse;
import com.msm.http.client.status.code.MMStatusCode;
import com.msm.http.client.utils.MMHttpUtils;
import com.msm.ssr.interfaces.ServiceRegistrationInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class ServiceRegistrationService implements ServiceRegistrationInterface {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private static final String SERVICE_ID_PARAMETER_NAME = "serviceId";
    private static final String SERVICE_HOST_PARAMETER_NAME = "serviceHost";
    private static final String SERVICE_HEALTH_CHECK_PARAMETER_NAME = "healthCheckEndpoint";
    private static final MMHttpClient client = new MMHttpClient();

    @Override
    public boolean register(String registerHost, String registrationEndpoint, String serviceId, String serviceHost, String healthCheckEndpoint) {
        try {
            String serviceRegisterUrl = MMUrlPathBuilder.buildUrl(registerHost, new String[]{registrationEndpoint});
            Map<String, String> parameters = MMHttpUtils.constructParametersMap(new String[]{SERVICE_ID_PARAMETER_NAME, SERVICE_HOST_PARAMETER_NAME, SERVICE_HEALTH_CHECK_PARAMETER_NAME}, new String[]{serviceId, serviceHost, healthCheckEndpoint});

            if (checkIfCallWasSuccessful(client.executePost(serviceRegisterUrl, parameters))) {
                return true;
            }

        } catch (MMUrlBuildException | IOException exception) {
            exception.printStackTrace();
        }

        LOGGER.debug("unsuccessfully registered");
        return false;
    }

    @Override
    public boolean deregister(String registerHost, String deregisterEndpoint, String serviceId) {
        try {
            String serviceRegisterUrl = MMUrlPathBuilder.buildUrl(registerHost, new String[]{deregisterEndpoint});
            Map<String, String> parameters = MMHttpUtils.constructParametersMap(new String[]{SERVICE_ID_PARAMETER_NAME}, new String[]{serviceId});

            if (checkIfCallWasSuccessful(client.executeGet(serviceRegisterUrl, parameters))) {
                LOGGER.debug("successfully unregistered");
                return true;
            }
        } catch (MMUrlBuildException | IOException e) {
            e.printStackTrace();
        }

        LOGGER.debug("unsuccessfully unregistered");
        return false;
    }

    private boolean checkIfCallWasSuccessful(MMHttpResponse response) {
        int statusCode = response.getStatusCode();
        return statusCode == MMStatusCode.OK;
    }

}
