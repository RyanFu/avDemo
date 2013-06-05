package com.demo.action.category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bo.Category;
import com.demo.DemoException;
import com.demo.action.AbstractAction;
import com.demo.dao.CategoryDAO;
import com.demo.dao.DAOFactory;

public class New extends AbstractAction {
	
	@Override
	protected int _doAction(HttpServletRequest req, HttpServletResponse res)
			throws DemoException {
		if(getSessionContainer(req).getUser()!=null){
			//TO-DO 查询需要的表单信息。
			CategoryDAO categoryDao = (CategoryDAO) DAOFactory.getDAO("CategoryDAO");
			Category cat = new Category(reqParams);
			categoryDao.save(cat);
			res.setStatus(200);
			writeResponse(Integer.toString(cat.getId()), res);
			//_forward(req, res);
		}else{
		    res.setStatus(403);
			this.reqParams.put("page", "403.jsp");
			_forward(req, res);
		}
		return 0;
	}
	
}
