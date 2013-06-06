package com.demo.action.movie;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DemoException;
import com.demo.ErrorCode;
import com.demo.action.AbstractAction;
import com.demo.bo.Category;
import com.demo.bo.Movie;
import com.demo.dao.CategoryDAO;
import com.demo.dao.CategoryRelationDAO;
import com.demo.dao.DAOFactory;
import com.demo.dao.MovieDAO;
import com.demo.util.json.JSONException;
import com.demo.util.json.JSONObject;

public class Create extends AbstractAction {

	@Override
	protected int _doAction(HttpServletRequest req, HttpServletResponse res)
			throws DemoException {
		if(getSessionContainer(req).getUser()!=null){
			//TO-DO 查询需要的表单信息。
			MovieDAO dao = (MovieDAO)DAOFactory.getDAO("MovieDAO");
			Movie movie = new Movie(reqParams);
			dao.save(movie);
			String categories[] = (String[])reqParams.get("category"); 
			CategoryRelationDAO catDao = (CategoryRelationDAO)DAOFactory.getDAO("CategoryRelationDAO");
			catDao.add_movie_relation(movie.getId(),categories);
			res.setStatus(200);
			this.writeResponse(Integer.toString(movie.getId()), res);
		}else{
		    res.setStatus(403);
			this.reqParams.put("page", "403.jsp");
			_forward(req, res);
		}
		return 0;
	}
	
}
