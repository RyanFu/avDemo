package com.demo.bo;

import java.io.Serializable;

public abstract class AbstractMovie extends AbstractBusinessObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String wiki;
	private int mark_time;
	private String total_mark;

	public AbstractMovie() {
	}
	
	public AbstractMovie(int id, String name, String wiki){
		this.id = id;
		this.name = name;
		this.wiki = wiki;
	}
	
	public AbstractMovie(int id, String name, String wiki, int mark_time, String total_mark){
		this.id = id;
		this.name = name;
		this.wiki = wiki;
		this.mark_time = mark_time;
		this.total_mark = total_mark;
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

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public int getMark_time() {
		return mark_time;
	}

	public void setMark_time(int mark_time) {
		this.mark_time = mark_time;
	}

	public String getTotal_mark() {
		return total_mark;
	}

	public void setTotal_mark(String total_mark) {
		this.total_mark = total_mark;
	}

}
