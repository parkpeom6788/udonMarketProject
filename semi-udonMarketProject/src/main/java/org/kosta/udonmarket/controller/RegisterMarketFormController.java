package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MemberVO;

public class RegisterMarketFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		int type = vo.getMemberType();
		if (type == 0) {
			request.setAttribute("url", "market/register-form-market.jsp");
		} else {
			request.setAttribute("url", "market/register-market-fail.jsp");
		}
		return "layout.jsp";
	}

}
