package com.msm.integration.pool.service.state.check.services.impl;

import com.msm.http.client.MMHttpClient;
import com.msm.http.client.builders.MMUrlPathBuilder;
import com.msm.http.client.exceptions.MMUrlBuildException;
import com.msm.http.client.response.MMHttpResponse;
import com.msm.http.client.status.code.MMStatusCode;
import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.integration.pool.service.state.check.services.HealthCheckService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * @author riste.jovanoski
 * @since 6/21/2017
 */
public class HealthCheckServiceImpl implements HealthCheckService {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public boolean isServiceActive(ServiceEntity serviceEntity) {
        try {
            String serviceHealthCheckUrl = MMUrlPathBuilder.buildUrl(serviceEntity.getServiceHost(), new String[]{serviceEntity.getHealthCheck()});
            MMHttpClient client = new MMHttpClient();
            MMHttpResponse response = client.executeGet(serviceHealthCheckUrl, null);

            int statusCode = response.getStatusCode();
            if (statusCode == MMStatusCode.OK) {
                LOGGER.debug(String.format("Service with id '%s' is active", serviceEntity.getServiceId()));
                return true;
            }

        } catch (MMUrlBuildException | IOException e) {
            e.printStackTrace();
        }

        LOGGER.debug(String.format("Service with id '%s' is NOT active", serviceEntity.getServiceId()));
        return false;
    }
}
