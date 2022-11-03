package org.kosta.udonmarket.test.pce;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class TestCaseLogin {
	public static void main(String[] args) {
		try {
			String id="java";
			String password="a";
			MemberVO memberVO=MemberDAO.getInstance().login(id,password);
			System.out.println("로그인 완료: "+memberVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
