package org.kosta.udonmarket.test.jsh;

import org.kosta.udonmarket.model.CommentDAO;
import org.kosta.udonmarket.model.CommentVO;

public class TestCaseWriteComment {
	public static void main(String[] args) {
		String id = "java2";
		long boardNo = 1;
		String content = "댓글테스트입니다!!";
		
		try {
			CommentDAO.getInstance().writeComment(content, boardNo, id);
			System.out.println("댓글등록 완료");
			long recentCommentNo = CommentDAO.getInstance().findRecentCommentNoByIdAndBoardNo(id,boardNo);
			CommentVO commentVO = CommentDAO.getInstance().findCommentByCommentNo(recentCommentNo);
			System.out.println(commentVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
