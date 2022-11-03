package org.kosta.udonmarket.test.kkb;

import org.kosta.udonmarket.model.MarketDAO;

public class TestCaseCheckMarketNo {
	public static void main(String[] args) {
		MarketDAO dao = MarketDAO.getInstance();
		String marketNo = "51111-12";
		try {
			boolean result = dao.checkMarketNo(marketNo);
			System.out.println("result : "+result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
