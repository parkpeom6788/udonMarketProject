package org.kosta.udonmarket.test.pp;

import java.sql.SQLException;

import org.kosta.udonmarket.model.MarketBoardDAO;

public class TestCaseHit {
	public static void main(String[] args) {
		try {
			MarketBoardDAO.getInstance().hit(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
