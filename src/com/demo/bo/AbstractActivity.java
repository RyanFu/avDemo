package com.demo.bo;
import java.io.Serializable;
import java.util.Date;

import com.demo.bo.AbstractBusinessObject;


public class AbstractActivity extends AbstractBusinessObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7796624883095617866L;
	
	private int id;
	private int action;
	private int target_id;
	private String target_type;

	public static String MOVIE = "movie";
	public static String ACTOR = "actor";
	public static String AGENCY = "agency";
	
	public static int PUBLISH = 0;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}

	public int getTarget_id() {
		return target_id;
	}
	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}
	public String getTarget_type() {
		return target_type;
	}
	public void setTarget_type(String target_type) {
		this.target_type = target_type;
	}

}
