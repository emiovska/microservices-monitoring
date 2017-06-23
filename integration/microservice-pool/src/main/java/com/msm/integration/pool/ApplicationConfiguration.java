package com.msm.integration.pool;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

/**
 * @author riste.jovanoski
 * @since 6/22/2017
 */
public class ApplicationConfiguration extends ResourceConfig {

    private static final String PACKAGES_SCANNER_LOCATION = "com.msm.sr.rest";
    private static final String APPLICATION_BASE_PATH = "/";

    public ApplicationConfiguration() {
        packages(PACKAGES_SCANNER_LOCATION);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, APPLICATION_BASE_PATH);
        register(JspMvcFeature.class);
    }

}
