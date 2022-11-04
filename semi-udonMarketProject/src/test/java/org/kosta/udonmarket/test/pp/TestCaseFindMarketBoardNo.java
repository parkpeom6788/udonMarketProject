package org.kosta.udonmarket.test.pp;

import java.sql.SQLException;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;

public class TestCaseFindMarketBoardNo {
	
	public static void main(String[] args) {
		try {
			MarketBoardVO marketBoardVO = MarketBoardDAO.getInstance().findMarketBoardByBoardNo(18);
			System.out.println(marketBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
