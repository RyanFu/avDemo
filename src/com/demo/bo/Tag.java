package com.demo.bo;

import java.util.Map;

import com.demo.util.json.JSONException;
import com.demo.util.json.JSONObject;
import com.demo.util.json.JSONObject.JSONObjectable;

public class Tag extends AbstractCategory implements JSONObjectable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2964518508386736882L;

	@Override
	public Object toJSONObject() throws JSONException {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("id", this.getId());
		o.put("name", this.getName());
		o.put("description", this.getDescription());
		return o;
	}
	
	public Tag(){
		
	}
	
	public Tag(Map<String,Object> params){
		super(params);
	}
	
	public static Tag parse(JSONObject o){
		Tag tag = new Tag();
		
		try{
			tag.setId(o.getInt("id"));
			tag.setName(o.getString("name"));
			tag.setDescription(o.getString("description"));
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		return tag;
	}

}
