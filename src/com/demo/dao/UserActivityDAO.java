package com.demo.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.demo.bo.User;
import com.demo.bo.UserActivity;

public class UserActivityDAO extends BaseHibernateDAO {
  private static final Log log = LogFactory.getLog(UserActivityDAO.class);


  public void save(UserActivity transientInstance) {
    log.debug("saving User instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    }
  }



  public UserActivity findByUserId(int id) {
    log.debug("getting UserActivity instance with user_id: " + id);
    try {
      UserActivity instance = (UserActivity) getSession().get("com.demo.bo.UserActivity", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    }
  }



  @SuppressWarnings("unchecked")
  public List<UserActivity> findRecnetly(){
	  try{
		  String queryString = "from UserActivity activity,User u where activity.user = u.id ";
		  Query queryObject = getSession().createQuery(queryString);
		  
		  return queryObject.list();
	  }catch(RuntimeException re){
		  log.error("find all failed", re);
	      throw re;		  
	  }
  }
  
  public List<UserActivity> findRecentlyById(){
	  return null;
  }


  public List findAll() {
//    log.debug("finding all User instances");
//    try {
//      String queryString = "from User";
//      Query queryObject = getSession().createQuery(queryString);
//      return queryObject.list();
//    } catch (RuntimeException re) {
//      log.error("find all failed", re);
//      throw re;
//    }
	  return null;
  }



  public void attachDirty(User instance) {
    log.debug("attaching dirty User instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }

  public void attachClean(User instance) {
    log.debug("attaching clean User instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    }
  }
}