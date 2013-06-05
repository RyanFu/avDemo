package com.demo.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.demo.bo.Category;

public class CategoryDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(CategoryDAO.class);
	
	public static final String NAME = "name";
	public static final String DESCRIPTION  = "description";

	public void save(Category transientInstance){
		log.debug("保存目录啦");
		try{
			getSession().save(transientInstance);
		}catch(RuntimeException re){
			log.error("见鬼了");
			throw re;
		}
	}
	
	  public List findByProperty(String propertyName, Object value) {
	    log.debug("finding Category instance with property: " + propertyName + ", value: " + value);
	    try {
	      String queryString = "from Category as model where model." + propertyName + "= ?";
	      Query queryObject = getSession().createQuery(queryString);
	      queryObject.setParameter(0, value);
	      return queryObject.list();
	    } catch (RuntimeException re) {
	      log.error("find by property name failed", re);
	      throw re;
	    }
	  }
	
	public List findByParentId(){
		return null;
	}
	
	public List<?> findAll(){
		try{
			String queryString = "from Category";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	
	public List findByMovieId(){
		return null;
	}
	
	
}
