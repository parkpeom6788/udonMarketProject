package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;
import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class RegisterMarketController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		
		String id = vo.getId();
		String marketName=request.getParameter("marketName");
		String marketAddress=request.getParameter("marketAddress");
		String marketTel=request.getParameter("marketTel");
		String info=request.getParameter("info");
		String item=request.getParameter("item");
		String marketNo=request.getParameter("marketNo");
		MarketVO marketVO = new MarketVO(id, marketName, marketAddress, marketTel, info, item, marketNo);
		
		MarketDAO.getInstance().registerMarket(marketVO);
		MemberDAO.getInstance().updateMemberType(id);
		MemberVO newVo = MemberDAO.getInstance().findMemberById(id);
		
		session.setAttribute("mvo", newVo);
		
		request.setAttribute("url", "market/register-market-result.jsp");
		return "layout.jsp";
	}

}
