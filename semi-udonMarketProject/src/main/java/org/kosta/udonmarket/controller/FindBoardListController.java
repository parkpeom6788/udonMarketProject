package org.kosta.udonmarket.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;
import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;
import org.kosta.udonmarket.model.Pagination;

public class FindBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pageNo = request.getParameter("pageNo");
		Pagination pagination = null;
		int totalPostCount = MarketBoardDAO.getInstance().getTotalPostCount(id);
		
		if(pageNo==null)
			pagination = new Pagination(totalPostCount);
		else
			pagination = new Pagination(totalPostCount,  Integer.parseInt(pageNo));
		
		MarketVO marketVO = MarketDAO.getInstance().findMarketInfo(id);	
		request.setAttribute("marketVO", marketVO);
		
		ArrayList<MarketBoardVO> list = MarketBoardDAO.getInstance().findBoardList(id, pagination);	// 게시글목록 부분
		request.setAttribute("id", id);
		request.setAttribute("pagination", pagination);	// 페이징버튼 부분
		request.setAttribute("boardList", list);	// boardNo는 rnum 으로 대체함
		request.setAttribute("url", "board/list.jsp");
		
		return "layout.jsp";
	}

}
