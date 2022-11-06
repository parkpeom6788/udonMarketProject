package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.udonmarket.model.CommentDAO;
import org.kosta.udonmarket.model.CommentVO;

public class WriteCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content = request.getParameter("content");
		long boardNo = Long.parseLong(request.getParameter("boardNo"));
		String id = request.getParameter("id");
		
		CommentDAO.getInstance().writeComment(content, boardNo, id);
		
		long recentCommentNo = CommentDAO.getInstance().findRecentCommentNoByIdAndBoardNo(id,boardNo);
		CommentVO commentVO = CommentDAO.getInstance().findCommentByCommentNo(recentCommentNo);

		JSONObject json = new JSONObject(commentVO);
		request.setAttribute("responsebody", json.toString());
		
		return "AjaxView";
	}

}
