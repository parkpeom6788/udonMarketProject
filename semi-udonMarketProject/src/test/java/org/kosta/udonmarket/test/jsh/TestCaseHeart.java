package org.kosta.udonmarket.test.jsh;

import org.kosta.udonmarket.model.LikeDAO;

public class TestCaseHeart {
	public static void main(String[] args) {
		String id = "java6";
		long boardNo = 7;
		
		try {
			boolean flag = LikeDAO.getInstance().select(id, boardNo);
			System.out.println(flag);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
