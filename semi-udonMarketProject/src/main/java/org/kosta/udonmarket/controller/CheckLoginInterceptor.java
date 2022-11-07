package org.kosta.udonmarket.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CheckLoginInterceptor {
	private static CheckLoginInterceptor instance=new CheckLoginInterceptor();
	private ArrayList<String> permitAllList=new ArrayList<>();
	private CheckLoginInterceptor() {
		permitAllList.add("FindBoardListController");
		permitAllList.add("FindMarketAllListController");
		permitAllList.add("FindMarketByNameController");
		permitAllList.add("FindMarketListSortByItemController");
		permitAllList.add("LoginController");
		permitAllList.add("LoginFormController");
		permitAllList.add("RegisterMemberController");
		permitAllList.add("RegisterMemberFormController");
		permitAllList.add("FindIdFormController");
		permitAllList.add("FindPasswordFormController");
		permitAllList.add("FindIdController");
		permitAllList.add("FindPasswordController");
		permitAllList.add("CheckIdController");
	}
	public static CheckLoginInterceptor getInstance() {
		return instance;
	}
	public boolean checkLogin(HttpServletRequest request,String controllerName) {
		boolean result=true;
		if(permitAllList.contains(controllerName)==false) {
			HttpSession session=request.getSession(false);
			if(session==null||session.getAttribute("mvo")==null) {
				result=false;
			}
		}
		return result;
	}
}
