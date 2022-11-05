package org.kosta.udonmarket.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;
import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;
import org.kosta.udonmarket.model.MemberVO;
import org.kosta.udonmarket.model.Pagination;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		Long board_no = Long.parseLong(request.getParameter("board_no"));
		
		MarketBoardDAO.getInstance().deleteMarket(board_no);
		
		MemberVO memberVO = (MemberVO)session.getAttribute("mvo");
		String id = memberVO.getId();
		MarketVO marketVO = MarketDAO.getInstance().findMarketInfo(id);
		
		String pageNo = request.getParameter("pageNo");
		Pagination pagination = null;
		int totalPostCount = MarketBoardDAO.getInstance().getTotalPostCount(id);
		
		if(pageNo==null)
			pagination = new Pagination(totalPostCount);
		else
			pagination = new Pagination(totalPostCount,  Integer.parseInt(pageNo));
		ArrayList<MarketBoardVO> boardList = MarketBoardDAO.getInstance().findBoardList(id, pagination);
		request.setAttribute("pagination", pagination);
		request.setAttribute("boardList", boardList);
		request.setAttribute("marketVO", marketVO);
		request.setAttribute("url", "board/list.jsp");	
		
		return "layout.jsp";
	}
}
