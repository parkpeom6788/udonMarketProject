package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class UpdateMemberInfoFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("memberId");
		MemberVO memberVO=MemberDAO.getInstance().findMemberById(id);
		request.setAttribute("memberVO", memberVO);
		request.setAttribute("url", "mypage/update-form-member.jsp");
		return "layout.jsp";
	}
}
