package com.demo.bo;

import com.demo.util.json.JSONException;
import com.demo.util.json.JSONObject;

public class Movie extends AbstractMovie {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Movie() {
	}

	public Movie(int id, String name, String wiki) {
		super(id, name, wiki);
	}

	public Movie(int id, String name, String wiki, int mark_time,
			String total_mark) {
		super(id, name, wiki, mark_time, total_mark);
	}

	public Object toJSONObject() throws JSONException {
		JSONObject o = new JSONObject();

		o.put("id", this.getId());
		o.put("name", this.getName());
		o.put("wiki", this.getWiki());
		o.put("mark_time", this.getMark_time());
		o.put("total_mark", this.getTotal_mark());

		return o;
	}

	public static Movie parse(JSONObject o) {

		Movie movie = new Movie();

		try {

			movie.setId(o.getInt("id"));
			movie.setName(o.getString("name"));
			movie.setWiki(o.getString("wiki"));
			movie.setMark_time((int) o.getInt("mark_time"));
			movie.setTotal_mark(o.getString("total_mark"));

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return movie;

	}
}
