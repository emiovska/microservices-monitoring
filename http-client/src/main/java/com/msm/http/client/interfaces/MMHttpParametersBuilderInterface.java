package com.msm.http.client.interfaces;

import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/16/2017
 */
public interface MMHttpParametersBuilderInterface {

    String buildHttpGetParameters(String url, Map<String, String> parameters);

    List<NameValuePair> buildHttpPostParameters(Map<String, String> parameters);

}
