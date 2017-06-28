package com.msm.msa.server.url.extractor;

import com.msm.ssr.exceptions.ApplicationServerUrlException;
import com.msm.ssr.server.url.extractor.ServerUrlExtractor;

/**
 * @author riste.jovanoski
 * @since 6/28/2017
 */
public class ProvidedUrlExtractor implements ServerUrlExtractor {

    private static final String MICROSERVICE_APPLICATION_URL = "https://mysterious-tundra-40078.herokuapp.com";

    @Override
    public String extractServerUrl(String s) throws ApplicationServerUrlException {
        return MICROSERVICE_APPLICATION_URL;
    }
}
