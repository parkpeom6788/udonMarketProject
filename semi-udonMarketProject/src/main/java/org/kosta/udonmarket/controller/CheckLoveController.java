package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.kosta.udonmarket.model.CheckHeartVO;
import org.kosta.udonmarket.model.LikeDAO;
import org.kosta.udonmarket.model.MemberVO;

public class CheckLoveController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		MemberVO memberVO= (MemberVO)session.getAttribute("mvo");
		String id = memberVO.getId(); // 사용자 아이디 
		Long boardNo = Long.parseLong(request.getParameter("board_no")); // 게시물 번호 
		
		String message = null;
		boolean checkClick = LikeDAO.getInstance().select(id, boardNo);
		if(checkClick==true) { // 사용자가 있으면
			LikeDAO.getInstance().delete(id, boardNo); // 좋아요 삭제 
			message = "fail";
		} else { // 사용자가 없으면
			LikeDAO.getInstance().insert(id, boardNo); // 좋아요 추가 
			message = "ok";
		}	

		long totalCount = LikeDAO.getInstance().count(boardNo);
		
		CheckHeartVO checkHeartVO = new CheckHeartVO(message,totalCount);
		JSONObject json = new JSONObject(checkHeartVO);
		
		request.setAttribute("message", message);
		request.setAttribute("responsebody", json);
		return "AjaxView";
	}
}
