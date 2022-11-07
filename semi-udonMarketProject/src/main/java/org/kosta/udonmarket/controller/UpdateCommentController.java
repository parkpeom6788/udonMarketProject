package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.CommentDAO;

public class UpdateCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long commentNo = Long.parseLong(request.getParameter("commentNo"));
		String newContent = request.getParameter("content");
		
		CommentDAO.getInstance().updateComment(commentNo, newContent);
		
		return "AjaxView";
	}

}
