package org.kosta.udonmarket.test.jsh;

import java.util.ArrayList;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;

public class TestCaseFindBoardList {
	public static void main(String[] args) {
		String id = "java4";
		try {
			ArrayList<MarketBoardVO> list = MarketBoardDAO.getInstance().findBoardList(id);
			for(MarketBoardVO m : list)
				System.out.println(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
