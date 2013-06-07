package com.demo.action.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DemoException;
import com.demo.action.AbstractAction;
import com.demo.bo.Movie;
import com.demo.dao.DAOFactory;
import com.demo.dao.MovieDAO;

public class Show extends AbstractAction {
	
	@Override
	protected int _doAction(HttpServletRequest req, HttpServletResponse res)
			throws DemoException {
		if(this.reqParams.get("id")!=null && getSessionContainer(req).getUser()!=null){
			//TO-DO 查询需要的表单信息。
			MovieDAO dao = (MovieDAO)DAOFactory.getDAO("MovieDAO");
			Movie movie = dao.findById(Integer.parseInt((String)this.reqParams.get("id")));
			req.setAttribute("movie", movie);
			res.setStatus(200);
			this.reqParams.put("page", "/movie/show.jsp");
			_forward(req, res);
		}else{
		    res.setStatus(403);
			this.reqParams.put("page", "403.jsp");
			_forward(req, res);
		}
		return 0;
	}
	
}
