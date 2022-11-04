package org.kosta.udonmarket.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class DeleteMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false)
			throw new ServletException("POST METHOD 방식만 가능");
		
		String id=request.getParameter("memberId");
		MemberDAO.getInstance().deleteMember(id);
		MemberVO mvo=MemberDAO.getInstance().findMemberById(id);
		HttpSession session=request.getSession(false);
		session.setAttribute("mvo", mvo);
		session.invalidate();
		return "mypage/delete-result-member.jsp";
	}

}
