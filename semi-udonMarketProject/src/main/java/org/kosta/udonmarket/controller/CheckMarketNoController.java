package org.kosta.udonmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.udonmarket.model.MarketDAO;

public class CheckMarketNoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String marketNo = request.getParameter("marketNo");
		String message = null;
		boolean result = MarketDAO.getInstance().checkMarketNo(marketNo);
		if(result) {
			message = "fail";
		}else {
			message = "ok";
		}
		request.setAttribute("responsebody", message);
		return "AjaxView";
	}

}
