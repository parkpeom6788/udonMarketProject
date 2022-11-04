package org.kosta.udonmarket.test.jsh;

import org.kosta.udonmarket.model.Pagination;

// 스터디용
public class TestPagination2 {

	public static void main(String[] args) {				
		Pagination p=new Pagination(48,9);
		System.out.println("startRowNumber:"+p.getStartRowNumber());	// 41
		System.out.println("endRowNumber:"+p.getEndRowNumber());	// 45
		System.out.println("totalPage:"+p.getTotalPage());	// 10		
		System.out.println("totalPageGroup:"+p.getTotalPageGroup());	// 3
		System.out.println("nowPageGroup:"+p.getNowPageGroup()); // 3
		System.out.println("startPageOfPageGroup:"+p.getStartPageOfPageGroup()); // 9
		System.out.println("endPageOfPageGroup:"+p.getEndPageOfPageGroup()); //10
		System.out.println("isPreviousPageGroup:"+p.isPreviousPageGroup()); // true
		System.out.println("isNextPageGroup:"+p.isNextPageGroup()); // false
		p=new Pagination(22,3);
		System.out.println("startRowNumber:"+p.getStartRowNumber());	// 11
		System.out.println("endRowNumber:"+p.getEndRowNumber());	// 15
		System.out.println("totalPage:"+p.getTotalPage());	// 5		
		System.out.println("totalPageGroup:"+p.getTotalPageGroup());	// 2
		System.out.println("nowPageGroup:"+p.getNowPageGroup()); // 1
		System.out.println("startPageOfPageGroup:"+p.getStartPageOfPageGroup()); //1
		System.out.println("endPageOfPageGroup:"+p.getEndPageOfPageGroup()); //4
		System.out.println("isPreviousPageGroup:"+p.isPreviousPageGroup()); // false
		System.out.println("isNextPageGroup:"+p.isNextPageGroup()); //true
	}
}
