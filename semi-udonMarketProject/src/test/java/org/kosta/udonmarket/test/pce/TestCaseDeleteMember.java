package org.kosta.udonmarket.test.pce;

import org.kosta.udonmarket.model.MemberDAO;

public class TestCaseDeleteMember {
	public static void main(String[] args) {
		try {
			String id="java11";
			MemberDAO.getInstance().deleteMember(id);
			System.out.println(id+"에 해당하는 회원탈퇴 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
