package com.demo.action.tag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bo.Category;
import com.demo.DemoException;
import com.demo.action.AbstractAction;
import com.demo.dao.CategoryDAO;
import com.demo.dao.DAOFactory;

public class list extends AbstractAction {
	
	@Override
	protected int _doAction(HttpServletRequest req, HttpServletResponse res)
			throws DemoException {
		if(getSessionContainer(req).getUser()!=null){
			//TO-DO 查询需要的表单信息。
			CategoryDAO categoryDao = (CategoryDAO) DAOFactory.getDAO("CategoryDAO");
			List<Category> categories = (List<Category>) categoryDao.findAll();
			req.setAttribute("categories", categories);
			
			//这里似乎应该返回json格式。
			
			res.setStatus(200);
			//this.writeResponse("asdasd", res);
			_forward(req, res);
		}else{
		    res.setStatus(403);
			this.reqParams.put("page", "403.jsp");
			_forward(req, res);
		}
		return 0;
	}
	
}
