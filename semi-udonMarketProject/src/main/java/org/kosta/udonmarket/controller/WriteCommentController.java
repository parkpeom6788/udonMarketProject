package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.CommentDAO;

public class WriteCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content = request.getParameter("content");
		long boardNo = Long.parseLong(request.getParameter("boardNo"));
		String id = request.getParameter("id");
		
		CommentDAO.getInstance().writeComment(content, boardNo, id);

		/*
			Ajax로 바로 댓글 등록상황이 보이는 경우 ( but 하나만 달 수 있음)
			long recentCommentNo = CommentDAO.getInstance().findRecentCommentNoByIdAndBoardNo(id,boardNo);
			CommentVO commentVO = CommentDAO.getInstance().findCommentByCommentNo(recentCommentNo);
	
			JSONObject json = new JSONObject(commentVO);
			request.setAttribute("responsebody", json.toString());
		*/
		
		return "AjaxView";
	}

}
