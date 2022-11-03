package org.kosta.udonmarket.controller;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false)
			throw new ServletException("POST METHOD 방식만 가능");
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		MemberVO memberVO=MemberDAO.getInstance().login(id, password);
		String viewPath=null;
		if(memberVO==null) {
			viewPath="redirect:member/login-fail.jsp";
		}else {
			viewPath="redirect:index.jsp";
			HttpSession session=request.getSession();
			session.setAttribute("mvo", memberVO);
			
			//조회수
			session.setAttribute("communityboard", new ArrayList<Long>());
		}
		return viewPath;
	}

}
