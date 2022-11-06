package org.kosta.udonmarket.model;

public class CommentVO {
	private long commentNo;
	private String commentContent;
	private String commentTimePosted;
	private String id;
	private long boardNo;
	
	public CommentVO() {
		super();
	}

	// 댓글 조회하기
	public CommentVO(long commentNo, String commentContent, String commentTimePosted, String id, long boardNo) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentTimePosted = commentTimePosted;
		this.id = id;
		this.boardNo = boardNo;
	}
	
	public CommentVO(String commentContent, String commentTimePosted, String id, long boardNo) {
		super();
		this.commentContent = commentContent;
		this.commentTimePosted = commentTimePosted;
		this.id = id;
		this.boardNo = boardNo;
	}

	// 댓글 작성하기
	public CommentVO(String commentContent, String id, long boardNo) {
		super();
		this.commentContent = commentContent;
		this.id = id;
		this.boardNo = boardNo;
	}

	public long getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentTimePosted() {
		return commentTimePosted;
	}

	public void setCommentTimePosted(String commentTimePosted) {
		this.commentTimePosted = commentTimePosted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(long boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentTimePosted="
				+ commentTimePosted + ", id=" + id + ", boardNo=" + boardNo + "]";
	}
	
}
