package org.kosta.udonmarket.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;
public class BoardDetailController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no = Long.parseLong(request.getParameter("board_no"));
		MarketBoardVO marketBoardVO = MarketBoardDAO.getInstance().boardDetail(no);
		MarketBoardDAO.getInstance().hit(no);
		request.setAttribute("vo", marketBoardVO);
		request.setAttribute("url", "board/detail-form.jsp");
		return "layout.jsp";
	}
}
