package org.kosta.udonmarket.test.jsh;

import java.util.ArrayList;

import org.kosta.udonmarket.model.MarketBoardDAO;
import org.kosta.udonmarket.model.MarketBoardVO;
import org.kosta.udonmarket.model.Pagination;

public class TestCaseFindBoardList {
	public static void main(String[] args) {
		try {
			String id = "java4";
			int totalPostCount = MarketBoardDAO.getInstance().getTotalPostCount(id);
			Pagination pagination = new Pagination(totalPostCount);
			
			ArrayList<MarketBoardVO> list = MarketBoardDAO.getInstance().findBoardList(id, pagination);
			for(MarketBoardVO m : list)
				System.out.println(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
