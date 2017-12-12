package ua.com.vit.connector;


import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class HibernateConnector {
    private static volatile HibernateConnector instance;

    private SessionFactory factory;
    private EntityManager entityManager;


    public static HibernateConnector getInstance() {
        if (instance == null) {
            synchronized (HibernateConnector.class) {
                if (instance == null) {
                    instance = new HibernateConnector();
                }
            }
        }
        return instance;
    }

    private HibernateConnector() {
        this.factory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        this.entityManager = factory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void begin() {
        if (!this.getTransaction().isActive()) {
            this.entityManager.getTransaction().begin();
        } else {
            // TODO log
            System.out.println("Transaction is already active");
        }
    }

    public void commit() {
        if (this.getTransaction().isActive()) {
            this.entityManager.getTransaction().commit();
        } else {
            // TODO log
            System.out.println("Transaction is not active (commit)");
        }
    }

    public void rollback() {
        if (this.getTransaction().isActive()) {
            this.entityManager.getTransaction().rollback();
        } else {
            // TODO log
            System.out.println("Transaction is not active (rollback)");
        }
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return this.entityManager.getCriteriaBuilder();
    }

    public <T> CriteriaQuery getQuery(Class<T> claz) {
        return this.entityManager.getCriteriaBuilder().createQuery(claz);
    }
    public <T> CriteriaQuery getQueryWithFrom(Class<T> claz) {
        CriteriaQuery<T> criteriaQuery= this.entityManager.getCriteriaBuilder().createQuery(claz);
        criteriaQuery.from(claz);
        return criteriaQuery;
    }
    public void close() {
        if (this.entityManager != null) {
            this.entityManager.close();
        }
        if (this.factory != null) {
            this.factory.close();
        }
    }

    public EntityTransaction getTransaction() {
        return this.getEntityManager().getTransaction();
    }
}
