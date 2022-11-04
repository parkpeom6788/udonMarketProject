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

public class UpdateBoardController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		MarketBoardVO marketBoardVO= (MarketBoardVO)request.getAttribute("marketBoardVO");
		
		MarketBoardDAO.getInstance().updateMarket(marketBoardVO.getBoardNo());
		
		MemberVO memberVO = (MemberVO)session.getAttribute("mvo");
		String id = memberVO.getId();
		
		MarketVO marketVO = MarketDAO.getInstance().findMarketInfo(id);
		ArrayList<MarketBoardVO> boardList = MarketBoardDAO.getInstance().findBoardList(id);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("marketVO", marketVO);
		request.setAttribute("url", "board/list.jsp");	
		return "layout.jsp";
	}

}
