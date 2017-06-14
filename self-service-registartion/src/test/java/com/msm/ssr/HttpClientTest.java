package com.msm.ssr;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
public class HttpClientTest {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void testHttpGet() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        try {
            HttpResponse response = client.execute(request);
            LOGGER.debug(response.getStatusLine().getStatusCode());
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            LOGGER.debug(stringBuilder.toString());
            Assert.assertNotEquals(stringBuilder.length(), 0);
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());

        }
    }

    @Test
    public void testHttpPost() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("title", "tester"));
        urlParameters.add(new BasicNameValuePair("body", "tester"));
        urlParameters.add(new BasicNameValuePair("userId", "1"));

        try {
            request.setEntity(new UrlEncodedFormEntity(urlParameters));
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            LOGGER.debug(statusCode);
            Assert.assertEquals(201, statusCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            LOGGER.debug(stringBuilder.toString());
            Assert.assertNotEquals(stringBuilder.length(), 0);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
