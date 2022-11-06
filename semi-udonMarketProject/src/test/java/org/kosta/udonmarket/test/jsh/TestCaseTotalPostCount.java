package org.kosta.udonmarket.test.jsh;

import org.kosta.udonmarket.model.MarketBoardDAO;

public class TestCaseTotalPostCount {
	public static void main(String[] args) {
		String id = "java4";
		try {
			int totalPostCount = MarketBoardDAO.getInstance().getTotalPostCount(id);
			System.out.println(totalPostCount);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
