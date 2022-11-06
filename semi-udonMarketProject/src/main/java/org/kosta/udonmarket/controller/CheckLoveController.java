package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class CheckLoveController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 2. 하트 체크 해제만 되면 id 와 board_no 일치하는 회원이 한번만 좋아요를 할수있게할것임
		// 3. 좋아요 개수 udon_like 테이블 컬럼에 좋아요 개수 컬럼 추가 해서 db에 반영할것임
		//HttpSession session = request.getSession(false);
		//MemberVO memberVO= (MemberVO)session.getAttribute("mvo");
		//String boardNo =request.getParameter("board_no");

		
		
		// 1. 일단 하트  체크 해제 되는지 부터  
		boolean result = request.getParameter("checkFlag") != null; 
	    
		System.out.println(result); 
		
		String message = null;
		
		if(result) {
			message ="fail";
		} else {
			message ="ok";
		}
		request.setAttribute("responsebody", message);
		return "AjaxView";
	}
}
