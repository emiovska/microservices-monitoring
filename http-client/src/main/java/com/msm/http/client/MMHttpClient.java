package com.msm.http.client;

import com.msm.http.client.builders.MMHttpParametersBuilder;
import com.msm.http.client.interfaces.MMHttpClientInterface;
import com.msm.http.client.response.MMHttpResponse;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/16/2017
 */
@SuppressWarnings("unused")
public class MMHttpClient implements MMHttpClientInterface {

    private static final MMHttpParametersBuilder parametersBuilder = new MMHttpParametersBuilder();

    private final HttpClient client;

    public MMHttpClient() {
        this.client = HttpClientBuilder.create().build();
    }

    @Override
    public MMHttpResponse executeGet(String url, Map<String, String> parameters) throws IOException {
        url = parametersBuilder.buildHttpGetParameters(url, parameters);
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        return new MMHttpResponse(response);
    }

    @Override
    public MMHttpResponse executePost(String url, Map<String, String> parameters) throws IOException {
        HttpPost request = new HttpPost(url);
        List<NameValuePair> urlParameters = parametersBuilder.buildHttpPostParameters(parameters);
        request.setEntity(new UrlEncodedFormEntity(urlParameters));
        return new MMHttpResponse(client.execute(request));
    }
}
