package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class DeleteMarketController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		String id = vo.getId();
				
		String marketNo = request.getParameter("no");
		 MarketDAO.getInstance().deleteMarketByNo(marketNo);
		 MemberDAO.getInstance().updateMemberTypeMinus(id);
		MemberVO mvo = MemberDAO.getInstance().findMemberById(id);
		session.setAttribute("mvo", mvo);
		request.setAttribute("url", "mypage/delete-market-result.jsp");
		return "layout.jsp";
	}

}
