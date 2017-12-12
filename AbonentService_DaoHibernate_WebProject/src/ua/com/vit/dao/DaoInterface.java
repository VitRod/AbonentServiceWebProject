package ua.com.vit.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import ua.com.vit.connector.HibernateConnector;

public interface DaoInterface<T, P extends Serializable> {
	 @SuppressWarnings("unchecked")
	    default T findById(P id) {
	        T entity = null;
	        Class<T> entityType = (Class<T>) ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
	        Class<P> primaryKeyType = (Class<P>) ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[1];
	        System.out.println("[via interface] Entity type = " + entityType.getCanonicalName() + " ; PrimaryKey type = " + primaryKeyType.getCanonicalName());

	        HibernateConnector hibernateConnector = HibernateConnector.getInstance();
	        hibernateConnector.getTransaction();
	        try {
	            hibernateConnector.begin();
	            entity = hibernateConnector.getEntityManager().find(entityType, id);
	            hibernateConnector.commit();
	        } catch (Exception e) {
	            hibernateConnector.rollback();
	        }
	        return entity;
	    }
	 
	 default <Z> Z universal(Function<EntityManager, Z> anyFunction) {
	        HibernateConnector hibernateConnector = HibernateConnector.getInstance();
	        hibernateConnector.begin();
	        Z result = anyFunction.apply(hibernateConnector.getEntityManager());
	        hibernateConnector.commit();
	        return result;
	    }
	 
	 @SuppressWarnings("unchecked")
	    default T findById2(P id) {
	        Class<T> entityType = (Class<T>) ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
	        return  universal((em) -> em.find(entityType, id));
	    }


	    @SuppressWarnings("unchecked")
	
	    default List<T> findAll() {
	        Class<T> entityType = (Class<T>) ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];

	        CriteriaQuery<T> criteriaQuery = HibernateConnector.getInstance().getQueryWithFrom(entityType);

	        return universal((em) -> em.createQuery(criteriaQuery).getResultList());
	    }
}
