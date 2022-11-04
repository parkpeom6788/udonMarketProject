package org.kosta.udonmarket.test.pce;

import org.kosta.udonmarket.model.MemberDAO;
import org.kosta.udonmarket.model.MemberVO;

public class TestCaseUpdateMember {
	public static void main(String[] args) {
		MemberVO memberVO=new MemberVO();
		memberVO.setId("1111");
		memberVO.setPassword("1111");
		memberVO.setName("장주주");
		memberVO.setTel("111-1111-1111");
		try {
			MemberDAO.getInstance().updateMember(memberVO);
			System.out.println(memberVO+" 회원정보 수정완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
