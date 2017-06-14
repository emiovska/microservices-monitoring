package com.msm.ssr.services;

import com.msm.ssr.exceptions.UrlBuildException;
import com.msm.ssr.interfaces.ServiceRegistrationInterface;
import com.msm.ssr.builders.UrlPathBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/14/2017
 */
public class ServiceRegistrationService implements ServiceRegistrationInterface {

    private static final String SERVICE_ID_PARAMETER_NAME = "serviceId";
    private static final String SERVICE_HOST_PARAMETER_NAME = "serviceHost";
    private static final String SERVICE_HEALTH_CHECK_PARAMETER_NAME = "healthCheckEndpoint";

    @Override
    public boolean register(String registerHost, String registrationEndpoint, String serviceId, String serviceHost, String healthCheckEndpoint) {
        try {
            String serviceRegisterUrl = UrlPathBuilder.buildUrl(registerHost, new String[]{registrationEndpoint});
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(serviceRegisterUrl);

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair(SERVICE_ID_PARAMETER_NAME, serviceId));
            urlParameters.add(new BasicNameValuePair(SERVICE_HOST_PARAMETER_NAME, serviceHost));
            urlParameters.add(new BasicNameValuePair(SERVICE_HEALTH_CHECK_PARAMETER_NAME, healthCheckEndpoint));

            request.setEntity(new UrlEncodedFormEntity(urlParameters));
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            return statusCode == HttpStatus.SC_OK;

        } catch (UrlBuildException | IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean unregister(String registerHost, String unregisterEndpoint, String serviceId) {
        try {
            String serviceRegisterUrl = UrlPathBuilder.buildUrl(registerHost, new String[]{unregisterEndpoint});
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(serviceRegisterUrl);

            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            return statusCode == HttpStatus.SC_OK;

        } catch (UrlBuildException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
