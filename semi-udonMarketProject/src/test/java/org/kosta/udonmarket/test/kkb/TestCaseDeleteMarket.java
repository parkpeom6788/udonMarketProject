package org.kosta.udonmarket.test.kkb;

import org.kosta.udonmarket.model.MarketDAO;

public class TestCaseDeleteMarket {
	public static void main(String[] args) {
		try {
			String marketNo = "65491-48";
			MarketDAO.getInstance().deleteMarketByNo(marketNo);
			System.out.println(marketNo+ "마켓 삭제");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
