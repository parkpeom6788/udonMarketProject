package org.kosta.udonmarket.test.jsh;

import org.kosta.udonmarket.model.CommentDAO;

public class TestCaseDeleteComment {
	public static void main(String[] args) {
		long commentNo = 61L;
		try {
			CommentDAO.getInstance().deleteComment(commentNo);
			System.out.println("삭제완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	}
