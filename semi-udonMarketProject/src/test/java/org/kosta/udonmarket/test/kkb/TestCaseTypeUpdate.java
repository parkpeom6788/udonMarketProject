package org.kosta.udonmarket.test.kkb;

import org.kosta.udonmarket.model.MemberDAO;

public class TestCaseTypeUpdate {
	public static void main(String[] args) {
		try {
			String id = "java3";
			
			MemberDAO.getInstance().updateMemberTypeMinus(id);
			System.out.println(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
