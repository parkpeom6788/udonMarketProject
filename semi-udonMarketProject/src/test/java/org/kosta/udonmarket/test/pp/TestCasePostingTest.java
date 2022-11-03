package org.kosta.udonmarket.test.pp;

import java.sql.SQLException;
import org.kosta.udonmarket.model.MarketBoardDAO;

public class TestCasePostingTest {
	public static void main(String[] args) {
		try {
			MarketBoardDAO.getInstance().posting("제목","내용","java5");
			System.out.println("작성완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
