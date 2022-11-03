package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MemberDAO;

public class CheckIdController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String message = null;
		boolean result = MemberDAO.getInstance().checkId(id);
		if(result) {
			message = "fail";
		}else {
			message = "ok";
		}
		request.setAttribute("responsebody", message);
		return "AjaxView";
	}

}
