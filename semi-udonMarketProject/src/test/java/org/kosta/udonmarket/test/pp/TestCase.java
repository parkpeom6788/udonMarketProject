package org.kosta.udonmarket.test.pp;

import java.sql.SQLException;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;

public class TestCase {
	
	public static void main(String[] args) {
		
		try {
			MarketBoardVO  vo = MarketBoardDAO.getInstance().boardDetail(1);
			System.out.println(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
