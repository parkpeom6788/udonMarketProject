package org.kosta.udonmarket.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.CommentDAO;
import org.kosta.udonmarket.model.CommentVO;
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
		Long no = Long.parseLong(request.getParameter("board_no"));
		
		MarketBoardVO marketBoardVO = MarketBoardDAO.getInstance().boardDetail(no);
		@SuppressWarnings("unchecked")
		ArrayList<Long>listhits =  (ArrayList<Long>) session.getAttribute("communityboard");
			if(listhits.contains(no)==false) {
				MarketBoardDAO.getInstance().hit(no);
				listhits.add(no);
			}
		
		request.setAttribute("id", id);
		request.setAttribute("vo", marketBoardVO);

		session.setAttribute("memberVO", memberVO);	

		ArrayList<CommentVO> list = CommentDAO.getInstance().findCommentList(no);
		request.setAttribute("commentList", list);

		request.setAttribute("url", "board/detail-form.jsp");	

		return "layout.jsp";
	}
}
