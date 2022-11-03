package org.kosta.udonmarket.test.jsh;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class TestCaseFindMarketInfo {
	public static void main(String[] args) {
		String id = "java";
		try {
			MarketVO marketVO = MarketDAO.getInstance().findMarketInfo(id);
			System.out.println(marketVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
