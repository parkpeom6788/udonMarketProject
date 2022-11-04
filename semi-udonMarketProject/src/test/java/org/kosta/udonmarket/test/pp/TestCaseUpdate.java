package org.kosta.udonmarket.test.pp;

import java.sql.SQLException;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketVO;
public class TestCaseUpdate {
	public static void main(String[] args) {
		MarketVO marketVO = null;
		try {
			MarketBoardDAO.getInstance().updateMarket("수정됏나?", "수정됏나?", 2);
			System.out.println("수정완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
