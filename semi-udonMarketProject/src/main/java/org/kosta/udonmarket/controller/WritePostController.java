package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.kosta.udonmarket.model.MarketBoardDAO;
public class WritePostController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//HttpSession session = request.getSession(false);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//MarketVO marketVO = (MarketVO)session.getAttribute("MarketVO");
		request.setAttribute(title, "title");
		request.setAttribute(content, "content");
//		if(session != null || marketVO != null) {
			MarketBoardDAO.getInstance().posting(title, content, "java2");
//		}
		return "redirect:board/list.jsp";
	}
}
