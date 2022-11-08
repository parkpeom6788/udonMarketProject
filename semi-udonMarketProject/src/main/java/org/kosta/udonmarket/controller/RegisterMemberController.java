package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class RegisterMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		MemberVO memberVO = new MemberVO(id,password,0,name,no,address,tel);
		dao.registerMember(memberVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("mvo", memberVO);
		
		return  "redirect:member/register-member-result.jsp";
	}

}
