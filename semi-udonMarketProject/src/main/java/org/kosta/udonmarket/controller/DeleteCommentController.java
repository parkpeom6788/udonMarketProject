package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.CommentDAO;

public class DeleteCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long commentNo = Long.parseLong(request.getParameter("commentNo"));
		CommentDAO.getInstance().deleteComment(commentNo);
		
		request.setAttribute("responsebody", "삭제완료");
		
		return "AjaxView";
	}

}
