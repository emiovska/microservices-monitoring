package com.msm.ssr.server.url.extractor.impl;

import com.msm.property.file.loader.service.PropertiesFilesService;
import com.msm.ssr.exceptions.ApplicationServerUrlException;
import com.msm.ssr.host.type.ServiceHostType;
import com.msm.ssr.properties.representations.ServiceProperties;
import com.msm.ssr.server.url.extractor.ServerUrlExtractor;

/**
 * @author riste.jovanoski
 * @since 6/28/2017
 */
public class ServerUrlExtractorImpl implements ServerUrlExtractor {

    private static final ServiceProperties serviceProperties = PropertiesFilesService.getPropertiesResource(ServiceProperties.class);

    @Override
    public String extractServerUrl(String contextPath) throws ApplicationServerUrlException {
        String hostnameOverIp = serviceProperties.getUseHostnameOverIp();
        if (hostnameOverIp != null && hostnameOverIp.equals("true")) {
            return ServiceHostType.HOSTNAME.getServiceAddress(contextPath);
        }
        return ServiceHostType.IP.getServiceAddress(contextPath);
    }

}
