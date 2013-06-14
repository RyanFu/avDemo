package com.demo.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.demo.bo.Movie;

public class MovieDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(MovieDAO.class);

	public static final String NAME = "name";
	public static final String WIKI = "wiki";
	public static final String MARK_TIME = "mark_time";
	public static final String TOTAL_MARK = "total_mark";

	public void save(Movie transientInstance) {
		log.debug("saving Movie instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movie persistentInstance) {
		log.debug("deleting Movie instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movie findById(int id) {
		log.debug("getting Movie instance with id: " + id);
		try {
			Movie instance = (Movie) getSession().get("com.demo.bo.Movie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(Movie instance) {
		log.debug("finding Movie instance by example");
		try {
			List<?> results = getSession().createCriteria("com.demo.bo.Movie")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<?> findByProperty(String propertyName, Object value) {
		log.debug("finding Movie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Movie as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByName(String name) {
		return findByProperty(NAME, name);
	}

	public List<?> findByMarkTime(String mark_time) {
		return findByProperty(MARK_TIME, mark_time);
	}

	public List<?> findByTotalMark(String total_mark) {
		return findByProperty(TOTAL_MARK, total_mark);
	}
	
	
	/**
	 * 
	 * @param perPage 每页多少条记录
	 * @param curPage 当前页
	 * @return
	 */
	public List<?> findByPage(int curPage,int perPage){
		log.debug("finding paginate Movie instances");
		try {
			String queryString = "from Movie order by id desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setMaxResults(perPage);
			queryObject.setFirstResult(curPage);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<?> findAll() {
		log.debug("finding all Movie instances");
		try {
			String queryString = "from Movie";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Movie merge(Movie detachedInstance) {
		log.debug("merging Movie instance");
		try {
			Movie result = (Movie) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movie instance) {
		log.debug("attaching dirty Movie instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movie instance) {
		log.debug("attaching clean Movie instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
