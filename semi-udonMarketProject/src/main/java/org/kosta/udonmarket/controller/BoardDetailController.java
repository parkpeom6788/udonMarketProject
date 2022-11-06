package org.kosta.udonmarket.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;
import org.kosta.udonmarket.model.MemberVO;
public class BoardDetailController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		
		// 특정사용자 계정 불러옴 
		MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
		String id = request.getParameter("id");
		
		long no = Long.parseLong(request.getParameter("board_no"));
		MarketBoardVO marketBoardVO = MarketBoardDAO.getInstance().boardDetail(no);
		MarketBoardDAO.getInstance().hit(no);
		
		request.setAttribute("id", id);
		request.setAttribute("vo", marketBoardVO);
		session.setAttribute("memberVO", memberVO);	
		request.setAttribute("url", "board/detail-form.jsp");
		return "layout.jsp";
	}
}
