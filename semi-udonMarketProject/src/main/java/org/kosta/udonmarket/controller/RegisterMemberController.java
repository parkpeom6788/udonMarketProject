package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		dao.registerMember(new MemberVO(id,password,0,name,no,address,tel));
		
		return  "redirect:member/register-member-result.jsp";
	}

}
