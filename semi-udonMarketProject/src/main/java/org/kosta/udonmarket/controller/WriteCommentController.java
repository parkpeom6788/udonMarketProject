package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.CommentDAO;

public class WriteCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("boardNo");
		long boardNo = Long.parseLong(no);
		String id = request.getParameter("id");
		String ccontent = request.getParameter("commentContent");
		
		CommentDAO.getInstance().writeComment(ccontent, boardNo, id);
		request.setAttribute("board_no", no);
		
		return "";
	}

}
