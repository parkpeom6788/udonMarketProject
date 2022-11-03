package org.kosta.udonmarket.test.kkb;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class TestCaseRegisterMember {
	public static void main(String[] args) {
		MemberVO vo = new MemberVO("javaa","a",0,"장기하","900111-121","오리","010-1231-1231");
		try {
			MemberDAO.getInstance().registerMember(vo);
			System.out.println(vo.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
