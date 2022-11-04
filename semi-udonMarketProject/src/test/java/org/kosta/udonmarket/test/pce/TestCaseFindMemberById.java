package org.kosta.udonmarket.test.pce;

import java.sql.SQLException;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class TestCaseFindMemberById {
	public static void main(String[] args) {
		String id="1111";
		MemberVO memberVO;
		try {
			memberVO = MemberDAO.getInstance().findMemberById(id);
			System.out.println("회원정보:"+memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
