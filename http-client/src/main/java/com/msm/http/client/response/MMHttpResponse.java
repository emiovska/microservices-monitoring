package com.msm.http.client.response;

import com.msm.http.client.interfaces.MMHttpResponseInterface;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author riste.jovanoski
 * @since 6/16/2017
 */
public class MMHttpResponse implements MMHttpResponseInterface {

    private final HttpResponse response;

    public MMHttpResponse(HttpResponse response) {
        this.response = response;
    }

    @Override
    public int getStatusCode() {
        return this.response.getStatusLine().getStatusCode();
    }

    @Override
    public InputStream getContent() throws IOException {
        return this.response.getEntity().getContent();
    }
}
