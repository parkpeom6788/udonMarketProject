package org.kosta.udonmarket.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class FindMarketByNameController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchInfo = request.getParameter("searchInfo");
		ArrayList<MarketVO> list = MarketDAO.getInstance().findMarketListByName(searchInfo);
		request.setAttribute("title", "\'"+searchInfo+"\' 의 검색 결과");
		request.setAttribute("marketList", list);
		request.setAttribute("url", "home-market-list.jsp");
		return "home.jsp";
	}

}
