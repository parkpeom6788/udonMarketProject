package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

import org.kosta.udonmarket.model.MemberVO;

public class MypageFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO memberVO=(MemberVO) session.getAttribute("mvo");
		String id = memberVO.getId();
		MarketVO marketVO = MarketDAO.getInstance().findMarketInfo(id);
		request.setAttribute("marketVO", marketVO);

		request.setAttribute("url", "mypage/mypage-info.jsp");
		return "layout.jsp";
	}
}
