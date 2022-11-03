package org.kosta.udonmarket.test.jsh;

import java.util.ArrayList;

import org.kosta.udonmarket.model.MarketDAO;
import org.kosta.udonmarket.model.MarketVO;

public class TestCaseFindMarketAllList {
	public static void main(String[] args) {
		try {
			ArrayList<MarketVO> list = MarketDAO.getInstance().findMarketAllList();
			for(MarketVO m : list)
				System.out.println(m);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
