package org.kosta.udonmarket.model;

public class HeartVO {
	private String id;
	private long boardNo;
	private long heartCount;

	public HeartVO() {
		super();
	}

	public HeartVO(String id, long boardNo, long heartCount) {
		super();
		this.id = id;
		this.boardNo = boardNo;
		this.heartCount = heartCount;
	}

	// 좋아요 클릭할 때
	public HeartVO(String id, long boardNo) {
		super();
		this.id = id;
		this.boardNo = boardNo;
	}

	// 게시물의 총 좋아요 갯수를 구할 때
	public HeartVO(long boardNo) {
		super();
		this.boardNo = boardNo;
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

	public long getHeartCount() {
		return heartCount;
	}

	public void setHeartCount(long heartCount) {
		this.heartCount = heartCount;
	}

	@Override
	public String toString() {
		return "HeartVO [id=" + id + ", boardNo=" + boardNo + ", heartCount=" + heartCount + "]";
	}

}
