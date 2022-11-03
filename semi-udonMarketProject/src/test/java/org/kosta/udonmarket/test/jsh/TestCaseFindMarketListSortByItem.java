package org.kosta.udonmarket.test.jsh;

import java.util.ArrayList;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class TestCaseFindMarketListSortByItem {
	public static void main(String[] args) {
		String item = "과일";
		try {
			ArrayList<MarketVO> list = MarketDAO.getInstance().findMarketListSortByItem(item);
			for(MarketVO m : list)
				System.out.println(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
