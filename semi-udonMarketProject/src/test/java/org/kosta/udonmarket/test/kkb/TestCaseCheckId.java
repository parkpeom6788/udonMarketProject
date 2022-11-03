package org.kosta.udonmarket.test.kkb;

import org.kosta.udonmarket.model.MemberDAO;

public class TestCaseCheckId {
	public static void main(String[] args) {
		MemberDAO dao = MemberDAO.getInstance();
		String id = "java";
		try {
			boolean result = dao.checkId(id);
			System.out.println("result : " +result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
