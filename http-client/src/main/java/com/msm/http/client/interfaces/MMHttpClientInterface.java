package com.msm.http.client.interfaces;


import com.msm.http.client.response.MMHttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/16/2017
 */
public interface MMHttpClientInterface {

    public MMHttpResponse executeGet(String url, Map<String, String> parameters) throws IOException;

    public MMHttpResponse executePost(String url, Map<String, String> parameters) throws IOException;

}