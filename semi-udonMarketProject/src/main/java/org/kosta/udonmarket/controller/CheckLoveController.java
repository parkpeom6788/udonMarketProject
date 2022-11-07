package org.kosta.udonmarket.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.LikeDAO;
import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class CheckLoveController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		
		MemberVO memberVO= (MemberVO)session.getAttribute("mvo");
		
		String id = memberVO.getId(); // 사용자 아이디 
		Long boardNo = Long.parseLong("board_no"); // 게시물 번호 
		
		String message = null;
	
		if(LikeDAO.getInstance().select(id, boardNo)) { // 사용자가 있으면
				LikeDAO.getInstance().delete(id, boardNo); // 좋아요 삭제 
					message = "fail";
		} else { // 사용자가 없으면
				LikeDAO.getInstance().insert(id, boardNo); // 좋아요 추가 
					message = "ok";
		}	
		request.setAttribute("responsebody", message);
		return "AjaxView";
	}
}
