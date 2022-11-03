package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteBoardFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 글쓰기 폼으로 이동
		request.setAttribute("url", "board/write-form.jsp");
		return "layout.jsp";
	}
}
