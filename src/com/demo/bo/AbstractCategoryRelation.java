package com.demo.bo;

import java.io.Serializable;

import com.demo.util.json.JSONObject.JSONObjectable;

public class AbstractCategoryRelation extends AbstractBusinessObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2170290778062232591L;

	private int id;
	
	private int category_id;
	
	private int actor_id;
	
	private int movie_id;
	
	private int agency_id;
	
	public static final int ACTOR = 1;
	public static final int MOVIE = 2;
	public static final int AGENCY = 3;
	
	public AbstractCategoryRelation(){
		
	}
	
	public AbstractCategoryRelation(int type,int id,int category_id){
		this.setCategory_id(category_id);
		switch(type){
			case AbstractCategoryRelation.ACTOR:
				this.setActor_id(id);
				break;
			case AbstractCategoryRelation.MOVIE:
				this.setMovie_id(id);
				break;
			case AbstractCategoryRelation.AGENCY:
				this.setAgency_id(id);
				break;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getAgency_id() {
		return agency_id;
	}

	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}
}
