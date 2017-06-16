package com.msm.http.client.builders;

import com.msm.http.client.interfaces.MMHttpParametersBuilderInterface;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author riste.jovanoski
 * @since 6/16/2017
 */
public class MMHttpParametersBuilder implements MMHttpParametersBuilderInterface {
    @Override
    public String buildHttpGetParameters(String url, Map<String, String> parameters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : parameters.keySet()) {
            stringBuilder.append(key).append("=").append(parameters.get(key)).append("&");
        }
        String params = stringBuilder.substring(0, (stringBuilder.length() - 1));
        stringBuilder.setLength(0);
        if (url.contains("?")) {
            stringBuilder.append(url).append(params);
        } else {
            stringBuilder.append(url).append("?").append(params);
        }
        return stringBuilder.toString();
    }

    @Override
    public List<NameValuePair> buildHttpPostParameters(Map<String, String> parameters) {
        List<NameValuePair> urlParameters = new ArrayList<>();
        for (String parameterKey : parameters.keySet()) {
            urlParameters.add(new BasicNameValuePair(parameterKey, parameters.get(parameterKey)));
        }
        return urlParameters;
    }
}
