package org.kosta.udonmarket.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MemberDAO;

public class DeleteMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false)
			throw new ServletException("POST METHOD 방식만 가능");
		
		
		HttpSession session=request.getSession(false);
		String id=request.getParameter("memberId");
		String password=request.getParameter("password");
		MemberDAO.getInstance().deleteMember(id, password);
		/*
		 * MemberVO mvo=MemberDAO.getInstance().findMemberById(id);
		 * session.setAttribute("mvo", mvo);
		 */
		session.invalidate();
		return "mypage/delete-result-member.jsp";
	}

}
