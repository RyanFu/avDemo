package com.demo.bo;

import java.util.Map;

import com.demo.util.json.JSONException;
import com.demo.util.json.JSONObject;
import com.demo.util.json.JSONObject.JSONObjectable;

public class CategoryRelation extends AbstractCategoryRelation implements JSONObjectable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5672281321025390276L;

	@Override
	public Object toJSONObject() throws JSONException {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("id", this.getId());
		o.put("category_id", this.getCategory_id());
		o.put("actor_id", this.getActor_id());
		o.put("agency_id",this.getAgency_id());
		o.put("movie_id",this.getMovie_id());
		
		return o;
	}
	
	public CategoryRelation(){
		
	}
	
	public CategoryRelation(int type,int id,int cat_id){
		super(type,id,cat_id);
	}
	
	public static CategoryRelation parse(JSONObject o){
		CategoryRelation cat = new CategoryRelation();
		
		try{
			cat.setId(o.getInt("id"));
			cat.setActor_id(o.getInt("actor_id"));
			cat.setMovie_id(o.getInt("movie_id"));
			cat.setAgency_id(o.getInt("agency_id"));
			cat.setCategory_id(o.getInt("categroy_id"));
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		return cat;
	}

}
