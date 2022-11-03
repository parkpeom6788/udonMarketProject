package org.kosta.udonmarket.test.jsh;

import java.util.ArrayList;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class TestCaseFindMarketListByName {
	public static void main(String[] args) {
		String searchInfo = "청과";
		try {
			ArrayList<MarketVO> list = MarketDAO.getInstance().findMarketListByName(searchInfo);
			for(MarketVO m : list)
				System.out.println(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
