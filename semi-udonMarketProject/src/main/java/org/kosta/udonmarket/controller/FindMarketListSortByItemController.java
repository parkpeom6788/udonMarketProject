package org.kosta.udonmarket.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class FindMarketListSortByItemController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String item = request.getParameter("item");
		ArrayList<MarketVO> list = MarketDAO.getInstance().findMarketListSortByItem(item);
		request.setAttribute("marketList", list);
		request.setAttribute("url", "home-market-list.jsp");
		return "home.jsp";
	}

}
