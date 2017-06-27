package com.msm.integration.pool.data.repository.impl;

import com.msm.integration.pool.data.hibernate.utils.HibernateUtils;
import com.msm.integration.pool.data.model.ServiceEntity;
import com.msm.integration.pool.data.repository.ServiceEntityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * @author riste.jovanoski
 * @since 6/20/2017
 */
public class ServiceEntityRepositoryImpl implements ServiceEntityRepository {

    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public ServiceEntity findById(Long id) {
        Session session = sessionFactory.openSession();
        ServiceEntity serviceEntity = session.get(ServiceEntity.class, id);
        session.close();
        return serviceEntity;
    }

    @Override
    public ServiceEntity findByServiceId(String serviceId) {
        Session session = sessionFactory.openSession();
        Query query = constructQueryByServiceId(session, serviceId);
        ServiceEntity serviceEntity;
        try {
            serviceEntity = (ServiceEntity) query.getSingleResult();
        } catch (NoResultException exception) {
            serviceEntity = null;
        } finally {
            session.close();
        }
        return serviceEntity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ServiceEntity> list() {
        Session session = sessionFactory.openSession();
        List services = session.createQuery("from ServiceEntity").list();
        session.close();
        return services;
    }

    @Override
    public void save(ServiceEntity serviceEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(serviceEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(ServiceEntity serviceEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(serviceEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(ServiceEntity serviceEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(serviceEntity);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    private Query constructQueryByServiceId(Session session, String serviceId) {
        String queryString = "FROM ServiceEntity where service_id = :service_id";
        Query query = session.createQuery(queryString);
        query.setParameter("service_id", serviceId);
        return query;
    }

}
