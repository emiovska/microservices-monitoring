package com.msm.integration.pool;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

/**
 * @author riste.jovanoski
 * @since 6/22/2017
 */
public class ApplicationConfiguration extends ResourceConfig {

    public ApplicationConfiguration() {
        packages("com.msm.sr.rest");
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/");
        register(JspMvcFeature.class);
    }

}
