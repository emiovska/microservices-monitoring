package com.msm.integration.pool;

import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.integration.pool.data.service.ServiceEntityService;
import com.msm.integration.pool.managers.ServiceManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
@SuppressWarnings("unused")
public class DataTest {

    private static final ServiceEntityService SERVICE_ENTITY_SERVICE = ServiceManager.getServiceEntityService();

    @Test
    public void testSaving() {
        SERVICE_ENTITY_SERVICE.save("first", "first", "first");
        SERVICE_ENTITY_SERVICE.save("second", "second", "second");
        SERVICE_ENTITY_SERVICE.save("third", "third", "third");
    }

    @Test
    @Ignore
    public void testGetting() {
        List<ServiceEntity> services = SERVICE_ENTITY_SERVICE.findAll();

        ServiceEntity first = SERVICE_ENTITY_SERVICE.findById(1L);
        ServiceEntity second = SERVICE_ENTITY_SERVICE.findById(2L);
        ServiceEntity third = SERVICE_ENTITY_SERVICE.findById(3L);
        Assert.assertNotNull(first);
        Assert.assertNotNull(second);
        Assert.assertNotNull(third);
    }

    @Test
    @Ignore
    public void testUpdating() {
        SERVICE_ENTITY_SERVICE.update(1L, "first-1", "first", "first");
    }

    @Test
    @Ignore
    public void testDeleting() {
        SERVICE_ENTITY_SERVICE.delete(1L);
        SERVICE_ENTITY_SERVICE.delete(2L);
        SERVICE_ENTITY_SERVICE.delete(3L);
    }

}
