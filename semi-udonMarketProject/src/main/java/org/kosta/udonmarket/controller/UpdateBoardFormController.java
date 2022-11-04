package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;

public class UpdateBoardFormController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long board_no = Long.parseLong(request.getParameter("board_no"));
		
		MarketBoardVO  marketBoardVO = MarketBoardDAO.getInstance().findMarketBoardByBoardNo(board_no);
		request.setAttribute("marketBoardVO", marketBoardVO);
		request.setAttribute("url", "board/update-form.jsp");
		return "layout.jsp";
	}
}