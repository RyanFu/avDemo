package com.demo.action.index;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DemoException;
import com.demo.action.AbstractAction;
import com.demo.bo.Movie;
import com.demo.bo.User;
import com.demo.dao.MovieDAO;

public class IndexAction extends AbstractAction {

	
	
	
	@Override
	protected int _doAction(HttpServletRequest req, HttpServletResponse res)
			throws DemoException {
		// TODO Auto-generated method stub
		try{
			req.setAttribute("title", "你好啊！~！~！~！~！");
			MovieDAO dao = new MovieDAO();
			List<Movie> list = (List<Movie>) dao.findByPage(0, 5);
			req.setAttribute("newest", list);
			this.reqParams.put("page", "/index.jsp");
			_forward(req, res);
			
		}catch(Exception e){
			throw new DemoException(e);
		}
		return 0;
	}
	
//	
//	protected String title;
//	
//	public String getTitle(){
//		return this.title;
//	}
//	public void setTitle(String title){
//		this.title=title;
//	}

}