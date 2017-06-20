package com.msm.integration.pool.data.repository;

import com.msm.integration.pool.data.model.ServiceEntity;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public interface ServiceEntityRepository {

    public ServiceEntity findById(Long id);

    public ServiceEntity findByServiceId(String serviceId);

    public List<ServiceEntity> list();

    public void save(ServiceEntity serviceEntity);

    public void update(ServiceEntity serviceEntity);

    public void delete(ServiceEntity serviceEntity);

}
