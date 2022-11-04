package org.kosta.udonmarket.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class UpdateMemberInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false)
			throw new ServletException("POST METHOD 방식만 가능");
		
		String id=request.getParameter("memberId");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		MemberVO memberVO=new MemberVO();
		memberVO.setId(id);
		memberVO.setPassword(password);
		memberVO.setName(name);
		memberVO.setTel(tel);
		MemberDAO.getInstance().updateMember(memberVO);
		MemberVO mvo = MemberDAO.getInstance().findMemberById(id);
		request.getSession(false).setAttribute("mvo", mvo);
		request.setAttribute("url", "mypage/mypage-info.jsp");
		return "layout.jsp";
	}

}
