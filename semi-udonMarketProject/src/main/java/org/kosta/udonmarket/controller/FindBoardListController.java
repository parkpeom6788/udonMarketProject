package org.kosta.udonmarket.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;
import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class FindBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MarketVO marketVO = MarketDAO.getInstance().findMarketInfo(id);
		request.setAttribute("marketVO", marketVO);
		
		ArrayList<MarketBoardVO> list = MarketBoardDAO.getInstance().findBoardList(id);
		
		request.setAttribute("id", id);
		request.setAttribute("boardList", list);
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}

}
