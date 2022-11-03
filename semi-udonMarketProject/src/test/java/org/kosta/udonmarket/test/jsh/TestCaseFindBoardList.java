package org.kosta.udonmarket.test.jsh;

import java.util.ArrayList;

import org.kosta.udonmarket.model.MarketBoardVO;
import org.kosta.udonmarket.model.MarketDAO;

public class TestCaseFindBoardList {
	public static void main(String[] args) {
		try {
			ArrayList<MarketBoardVO> list = MarketDAO.getInstance().findBoardList();
			for(MarketBoardVO m : list)
				System.out.println(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
