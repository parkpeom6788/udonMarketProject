package org.kosta.udonmarket.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class FindMarketAllListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MarketVO> list = MarketDAO.getInstance().findMarketAllList();
		request.setAttribute("title", "All Market");
		request.setAttribute("marketList", list);
		request.setAttribute("url", "home-market-list.jsp");
		return "home.jsp";
	}

}
