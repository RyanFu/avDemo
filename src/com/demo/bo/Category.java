package com.demo.bo;

import java.util.Map;

import com.demo.util.json.JSONException;
import com.demo.util.json.JSONObject;
import com.demo.util.json.JSONObject.JSONObjectable;

public class Category extends AbstractCategory implements JSONObjectable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4007537203275144892L;

	@Override
	public Object toJSONObject() throws JSONException {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("id", this.getId());
		o.put("name", this.getName());
		o.put("description", this.getDescription());
		o.put("parent_id",this.getParent_id());
		return o;
	}
	
	public Category(){
		
	}
	
	public Category(Map<String,Object> params){
		super(params);
	}
	
	public static Category parse(JSONObject o){
		Category cat = new Category();
		
		try{
			cat.setId(o.getInt("id"));
			cat.setName(o.getString("name"));
			cat.setDescription(o.getString("description"));
			cat.setParent_id(o.getInt("parent_id"));
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		return cat;
	}

}
