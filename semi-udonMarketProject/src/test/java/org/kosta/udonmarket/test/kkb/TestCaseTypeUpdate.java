package org.kosta.udonmarket.test.kkb;

import org.kosta.udonmarket.model.MemberDAO;

public class TestCaseTypeUpdate {
	public static void main(String[] args) {
		try {
			String id = "java11";
			System.out.println(MemberDAO.getInstance().updateMemberType(id));
			MemberDAO.getInstance().updateMemberType(id);
			System.out.println(MemberDAO.getInstance().updateMemberType(id));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
