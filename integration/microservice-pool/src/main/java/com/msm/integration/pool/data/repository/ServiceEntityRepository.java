package com.msm.integration.pool.data.repository;

import com.msm.integration.pool.data.model.ServiceEntity;

import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public interface ServiceEntityRepository {

    ServiceEntity findById(Long id);

    ServiceEntity findByServiceId(String serviceId);

    List<ServiceEntity> list();

    void save(ServiceEntity serviceEntity);

    void update(ServiceEntity serviceEntity);

    void delete(ServiceEntity serviceEntity);

}
