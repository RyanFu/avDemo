package com.demo.action.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DemoException;
import com.demo.action.AbstractAction;
import com.demo.bo.User;

public class IndexAction extends AbstractAction {

	
	
	
	@Override
	protected int _doAction(HttpServletRequest req, HttpServletResponse res)
			throws DemoException {
		// TODO Auto-generated method stub
		try{
			req.setAttribute("title", "你好啊！~！~！~！~！");
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
