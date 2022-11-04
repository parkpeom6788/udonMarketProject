package org.kosta.udonmarket.test.kkb;

import org.kosta.udonmarket.model.MarketDAO;

public class TestCaseUpdateMarket {
	public static void main(String[] args) {
		String name = "집";
		String tel = "010-2314-2577";
		String info = "변경 테스트";
		String id = "java";
		try {
			MarketDAO.getInstance().updateMarket(name,tel,info,id);
			System.out.println("수정완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
