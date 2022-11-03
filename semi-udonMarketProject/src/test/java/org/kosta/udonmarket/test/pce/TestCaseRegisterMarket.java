package org.kosta.udonmarket.test.pce;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class TestCaseRegisterMarket {
	public static void main(String[] args) {
		try {
			MarketDAO.getInstance().registerMarket(new MarketVO("java2", "사과청과", "판교", "010-7111-1111", "과일", "아삭한과일상점", "51111-11"));
			System.out.println("상점 등록 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
