package com.msm.sr;

import com.msm.property.file.loader.service.PropertiesFilesService;
import com.msm.sr.properties.representations.ServiceRegistrarProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author riste.jovanoski
 * @since 6/19/2017
 */
public class PropertiesLoaderTest {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void testProperties() {
        ServiceRegistrarProperties properties = PropertiesFilesService.getPropertiesResource(ServiceRegistrarProperties.class);
        Assert.assertNotNull(properties);
        Assert.assertNotNull(properties.getRegistrationEndpoint());
        Assert.assertNotNull(properties.getDeregistrationEndpoint());
        LOGGER.debug(properties.getRegistrationEndpoint());
        LOGGER.debug(properties.getDeregistrationEndpoint());
    }

}
