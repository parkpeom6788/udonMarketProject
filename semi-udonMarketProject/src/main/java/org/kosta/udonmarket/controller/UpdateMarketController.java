package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MemberVO;

public class UpdateMarketController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
		String id = memberVO.getId();
		String name = request.getParameter("marketName");
		String tel = request.getParameter("marketTel");
		String info = request.getParameter("marketInfo");
		MarketDAO.getInstance().updateMarket(name, tel, info, id);
		request.setAttribute("url", "mypage/update-result.jsp");
		return "layout.jsp";
	}

}
