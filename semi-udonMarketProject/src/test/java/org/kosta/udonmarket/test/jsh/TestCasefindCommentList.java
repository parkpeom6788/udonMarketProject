package org.kosta.udonmarket.test.jsh;

import java.util.ArrayList;

import org.kosta.udonmarket.model.CommentDAO;
import org.kosta.udonmarket.model.CommentVO;

public class TestCasefindCommentList {
	public static void main(String[] args) {
		int boardNo = 1;
		try {
			ArrayList<CommentVO> list = CommentDAO.getInstance().findCommentList(boardNo);
			for(CommentVO comment : list)
				System.out.println(comment);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
