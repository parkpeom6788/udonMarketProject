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
		permitAllList.add("FindIdPasswordFormController");
		permitAllList.add("FindIdController");
		permitAllList.add("FindPasswordController");
	}
	public static CheckLoginInterceptor getInstance() {
		return instance;
	}
	public boolean checkLogin(HttpServletRequest request,String controllerName) {
		boolean result=true;
		if(permitAllList.contains(controllerName)==false) {
			HttpSession session=request.getSession(false);
			if(session==null||session.getAttribute("mvo")==null) {
				System.out.println(controllerName+"=> 비인증 상태이므로 로그인해야 함");
				result=false;
			}
		}
		return result;
	}
}
