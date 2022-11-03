package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketVO;
import org.kosta.udonmarket.model.MemberVO;

public class WritePostController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title"+title);
		System.out.println("content"+content);

		MemberVO memberVO = (MemberVO)session.getAttribute("mvo");
		System.out.println(memberVO);
		String id = memberVO.getId();
		System.out.println(id);
	
		if(session != null || memberVO != null) {
			MarketBoardDAO.getInstance().posting(title, content, id);
		}
		return "board/list.jsp";
	}
}
