package com.msm.http.client.interfaces;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author riste.jovanoski
 * @since 6/16/2017
 */
public interface MMHttpResponseInterface {

    int getStatusCode();

    InputStream getContent() throws IOException;

}
