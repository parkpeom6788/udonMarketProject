package org.kosta.udonmarket.test.pce;

import org.kosta.udonmarket.model.MemberDAO;

public class TestCaseDeleteMember {
	public static void main(String[] args) {
		try {
			String id="java6";
			String password="a";
			MemberDAO.getInstance().deleteMember(id,password);
			System.out.println("회원탈퇴 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
