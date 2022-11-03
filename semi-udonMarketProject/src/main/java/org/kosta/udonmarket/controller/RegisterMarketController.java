package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class RegisterMarketController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		String id=(String) session.getAttribute("mvo");
		String marketName=request.getParameter("marketName");
		String marketAddress=request.getParameter("marketAddress");
		String marketTel=request.getParameter("marketTel");
		String info=request.getParameter("info");
		String item=request.getParameter("item");
		String marketNo=request.getParameter("marketNo");
		MarketDAO.getInstance().registerMarket(new MarketVO(id, marketName, marketAddress, marketTel, info, item, marketNo));
		session.setAttribute("url", "redirect:market/register-market-result.jsp");
		return "redirect:${pageContext.request.contextPath}/RegisterFormController.do";
	}

}
