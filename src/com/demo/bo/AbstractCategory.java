package com.demo.bo;

import java.util.Map;

import org.hibernate.validator.constraints.Length;

public class AbstractCategory extends AbstractBusinessObject implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1308179106819812956L;

	private int id;
	
	@Length(min = 4)
	private String name;
	
	private String description;
	
	private int parent_id;
	
	public AbstractCategory(){
		
	}
	
	
	public AbstractCategory(Map<String,Object> params){
		if(params.size()>0){
			this.updateAttributes(params);
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getParent_id() {
		return parent_id;
	}


	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

}
