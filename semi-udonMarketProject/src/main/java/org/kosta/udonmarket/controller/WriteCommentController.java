package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.CommentDAO;

public class WriteCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long boardNo = Long.parseLong(request.getParameter("boardNo"));
		String id = request.getParameter("id");
		String ccontent = request.getParameter("commentContent");
		
		CommentDAO.getInstance().writeComment(ccontent, boardNo, id);
		request.setAttribute("board_no", boardNo);
		
		return "redirect:BoardDetailController.do";
	}

}
