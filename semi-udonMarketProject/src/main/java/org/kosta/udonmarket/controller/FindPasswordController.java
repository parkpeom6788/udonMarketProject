package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class FindPasswordController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		String tel = request.getParameter("tel");
		MemberVO vo = MemberDAO.getInstance().findPasswordbyNameNoTel(id,name, no, tel);
		if (vo == null) {
			request.setAttribute("url", "member/find-fail-password.jsp");
		}else {
			request.setAttribute("url", "member/find-result-password.jsp");
			request.setAttribute("vo", vo);
		}
			return "layout.jsp";
	}
}
