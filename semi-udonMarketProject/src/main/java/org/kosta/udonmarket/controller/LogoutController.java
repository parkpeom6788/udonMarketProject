package org.kosta.udonmarket.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false)
			throw new ServletException("POST METHOD 방식만 가능");
		
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.invalidate();
		return "redirect:index.jsp";
	}

}
