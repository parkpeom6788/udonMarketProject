package org.kosta.udonmarket.model;

import java.io.Serializable;

public class MarketBoardVO implements Serializable{
	
	private static final long serialVersionUID = -7580902802194348215L;
	private long boardNo;
	private String title;
	private String content;
	private String imageName;
	private String timePosted;
	private long hits;
	private MarketVO marketVO;
	
	public MarketBoardVO() {
		super();
	}
	
	// 상세글보기
	public MarketBoardVO(long boardNo, String title, String content, String imageName, String timePosted, long hits, MarketVO marketVO) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.timePosted = timePosted;
		this.hits = hits;
		this.marketVO = marketVO;
	}

	// 게시글전체리스트
	public MarketBoardVO(long boardNo, String title, String timePosted, long hits, MarketVO marketVO) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.timePosted = timePosted;
		this.hits = hits;
		this.marketVO = marketVO;
	}
	
	//게시글 작성하기
	public MarketBoardVO(String title, String content, String imageName, MarketVO marketVO) {
		super();
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.marketVO = marketVO;
	}

	public MarketBoardVO(String imageName) {
		this.imageName = imageName;
	}

	public long getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(long boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public MarketVO getMarketVO() {
		return marketVO;
	}

	public void setMarketVO(MarketVO marketVO) {
		this.marketVO = marketVO;
	}

	@Override
	public String toString() {
		return "MarketBoardVO [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", imageName="
				+ imageName + ", timePosted=" + timePosted + ", hits=" + hits + ", marketVO=" + marketVO + "]";
	}
	
}
