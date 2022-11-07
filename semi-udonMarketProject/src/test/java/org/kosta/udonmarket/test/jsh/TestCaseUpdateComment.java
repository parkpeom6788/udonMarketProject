package org.kosta.udonmarket.test.jsh;

import org.kosta.udonmarket.model.CommentDAO;

public class TestCaseUpdateComment {
	public static void main(String[] args) {
		long commentNo = 5L;
		String newContent = "댓글 수정 테스트";
		try {
			System.out.println(CommentDAO.getInstance().findCommentByCommentNo(commentNo));
			CommentDAO.getInstance().updateComment(commentNo, newContent);
			System.out.println("수정완료");
			System.out.println(CommentDAO.getInstance().findCommentByCommentNo(commentNo));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
