package com.msm.ssr.server.url.extractor;

import com.msm.ssr.exceptions.ApplicationServerUrlException;

/**
 * @author riste.jovanoski
 * @since 6/28/2017
 */
public interface ServerUrlExtractor {

    String extractServerUrl(String applicationContextPath) throws ApplicationServerUrlException;

}
