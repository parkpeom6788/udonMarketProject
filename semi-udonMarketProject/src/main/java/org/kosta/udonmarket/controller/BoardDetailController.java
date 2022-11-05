package org.kosta.udonmarket.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.CommentDAO;
import org.kosta.udonmarket.model.CommentVO;
import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;
public class BoardDetailController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no = Long.parseLong(request.getParameter("board_no"));
		MarketBoardVO marketBoardVO = MarketBoardDAO.getInstance().boardDetail(no);
		MarketBoardDAO.getInstance().hit(no);
		request.setAttribute("vo", marketBoardVO);
		
		ArrayList<CommentVO> list = CommentDAO.getInstance().findCommentList(no);
		request.setAttribute("commentList", list);
		
		request.setAttribute("url", "board/detail-form.jsp");	
		return "layout.jsp";
	}
}
