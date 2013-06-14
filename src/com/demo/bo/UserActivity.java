package com.demo.bo;

import java.util.Date;
import java.util.Map;

import org.hibernate.validator.constraints.Length;

import com.demo.util.json.JSONException;
import com.demo.util.json.JSONObject;
import com.demo.util.json.JSONObject.JSONObjectable;

public class UserActivity extends AbstractActivity implements JSONObjectable {

  // Constructors

  /**
	 * 
	 */
	private static final long serialVersionUID = -7613991398324981154L;


	private int user_id;
	private String comment;
	private Date create_date;
	private User user;
	private String target_name;
	
	
	
	
/** default constructor */
  public UserActivity() {
	  this.create_date=new Date();
  }
  
  public UserActivity(Map<String,Object> params){
	  this.updateAttributes(params);
	  this.create_date=new Date();
  }
  
  public UserActivity(User user,int action,String type,int target,String name){
	  this.setUser(user);
	  this.setAction(action);
	  this.setTarget_type(type);
	  this.setTarget_id(target);
	  this.setTarget_name(name);
	  this.setCreate_date(new Date());
  }

  public UserActivity(User user,int action,String type,int target,String name ,String comment){
	  this.setUser(user);
	  this.setAction(action);
	  this.setTarget_type(type);
	  this.setTarget_id(target);
	  this.setTarget_name(name);
	  this.setComment(comment);
	  this.setCreate_date(new Date());
  }

  public Object toJSONObject() throws JSONException {
    JSONObject o = new JSONObject();
    
    o.put("id",this.getId());
    o.put("user_id", this.getUser_id());
    o.put("comment", this.getComment());
    o.put("create_date", this.getCreate_date());
    o.put("action", this.getAction());
    o.put("target_id", this.getTarget_id());
    o.put("target_type", this.getTarget_type());

    return o;
  }

  public static UserActivity parse(JSONObject o) {

    UserActivity activity = new UserActivity();

    try {
    	activity.setId(o.getInt("id"));
    	activity.setUser_id(o.getInt("user_id"));
    	activity.setAction(o.getInt("action"));
    	activity.setComment(o.getString("comment"));
    	activity.setTarget_id(o.getInt("target_id"));
    	activity.setTarget_type(o.getString("target_type"));
    	activity.setCreate_date((Date)o.get("create_date"));

    } catch (JSONException e) {

      e.printStackTrace();
    }

    return activity;

  }


public int getUser_id() {
	return user_id;
}


public void setUser_id(int user_id) {
	this.user_id = user_id;
}


public String getComment() {
	return comment;
}


public void setComment(String comment) {
	this.comment = comment;
}


public Date getCreate_date() {
	
	if(this.create_date!=null){
		this.create_date=new Date();
	}
	return create_date;
}


public void setCreate_date(Date create_date) {
	this.create_date = create_date;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public String getTarget_name() {
	return target_name;
}

public void setTarget_name(String target_name) {
	this.target_name = target_name;
}

}
