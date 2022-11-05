package org.kosta.udonmarket.model;

public class Pagination {

	private int nowPage = 1;
	private int postCountPerPage = 5;
	private int pageCountPerPageGroup = 4;
	private int totalPostCount;

	public Pagination(int totalPostCount) {
		super();
		this.totalPostCount = totalPostCount;
	}

	public Pagination(int totalPostCount, int nowPage) {
		super();
		this.totalPostCount = totalPostCount;
		this.nowPage = nowPage;
	}

	// getNowPage() - 현재 페이지로 버튼 색깔 다르게 줄 때 필요함
	public int getNowPage() {
		return this.nowPage;
	}

	// getStartRowNumber() - 해당 페이지에서 첫번째 게시물의 로우번호
	public int getStartRowNumber() {
		return (this.nowPage - 1) * this.postCountPerPage + 1;
	}

	// getEndRowNumber() - 해당 페이지에서 마지막 게시물의 로우번호
	public int getEndRowNumber() {
		int endRowNum = this.nowPage * this.postCountPerPage;
		if (endRowNum > this.totalPostCount)
			endRowNum = this.totalPostCount;
		return endRowNum;
	}

	// getTotalPageCount() - 총 페이지 수
	public int getTotalPage() {
		int totalPage = this.totalPostCount / this.postCountPerPage;
		if (this.totalPostCount % this.postCountPerPage != 0)
			totalPage += 1;
		return totalPage;
	}

	// getTotalPageGroupCount() - 총 페이지그룹 수
	public int getTotalPageGroup() {
		int totalPageGroup = getTotalPage() / this.pageCountPerPageGroup;
		if (getTotalPage() % this.pageCountPerPageGroup != 0)
			totalPageGroup += 1;
		return totalPageGroup;
	}

	// getNowPageGroup() - 현재 페이지에 해당하는 페이지 그룹
	public int getNowPageGroup() {
		int nowPageGroup = this.nowPage / this.pageCountPerPageGroup;
		if(this.nowPage % this.pageCountPerPageGroup!=0)
			nowPageGroup += 1;
		return nowPageGroup;
	}
	
	// getStartPageOfPageGroup() - 해당 페이지 그룹 내 첫번째 페이지 번호
	public int getStartPageOfPageGroup() {
		return (getNowPageGroup()-1)*this.pageCountPerPageGroup+1;
	}
	
	// getEndPageOfPageGroup() - 해당 페이지 그룹 내 마지막 페이지 번호
	public int getEndPageOfPageGroup() {
		int endPageOfPageGroup = getNowPageGroup() * this.pageCountPerPageGroup;
		if(endPageOfPageGroup>this.getTotalPage())
			endPageOfPageGroup = this.getTotalPage();
		return endPageOfPageGroup;
	}
	
	// isPreviousPageGroup() - previous 존재하는지 true/false
	public boolean isPreviousPageGroup() {
		boolean flag = false;
		if(this.getNowPageGroup()>1)
			flag = true;
		return flag;
	}
	
	// isNextPageGroup() - next 존재하는지 true/false
	public boolean isNextPageGroup() {
		boolean flag = false;
		if(this.getNowPageGroup()<this.getTotalPageGroup())
			flag = true;
		return flag;
	}
}





















