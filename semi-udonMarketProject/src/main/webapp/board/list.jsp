<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      

<h1>${requestScope.marketVO.marketName }</h1>
<table class="table table-bordered" style="border-width: 10px">
	<tr>
		<td>상점 이름</td><td>${requestScope.marketVO.marketName }</td>
	</tr>
	<tr>
		<td>상점 주소</td><td>${requestScope.marketVO.marketAddress }</td>
	</tr>
	<tr>
		<td>상점 전화번호</td><td>${requestScope.marketVO.marketTel }</td>
	</tr>
	<tr>
		<td>상품 품목</td><td>${requestScope.marketVO.item }</td>
	</tr>
	<tr>
		<td>상점 소개</td><td>${requestScope.marketVO.info }</td>
	</tr>
	<tr>
		<td>사업자등록번호</td><td>${requestScope.marketVO.marketNo }</td>
	</tr>
</table>
<br><br><br>


<h1>${requestScope.marketVO.marketName } 소식</h1>
<table class="table table-bordered table-hover" style="border-width: 10px">
	<thead style="text-align: center">
		<tr style="background-color:#000000">
			<th style="color: white">글번호</th>
			<th style="color: white">제목</th>
			<th style="color: white">작성일</th>
			<th style="color: white">조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.boardList }" var="list">
		<tr>
			<td style="text-align: center">${list.boardNo }</td>
			<td><a href="BoardDetailController.do?board_no=${list.boardNo}&id=${requestScope.id }">${list.title }</a></td>
			<td style="text-align: center">${list.timePosted }</td>
			<td style="text-align: center">${list.hits }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<ul class="pagination justify-content-center" style="margin:20px 0">
	<c:if test="${pagination.previousPageGroup }">
		<li class="page-item"><a class="page-link" href="FindBoardListController.do?pageNo=${pagination.startPageOfPageGroup-1 }&id=${requestScope.marketVO.id }">Previous</a></li>
	</c:if>
	<c:forEach begin="${pagination.startPageOfPageGroup }" end="${pagination.endPageOfPageGroup }" var="page">
		<c:choose>
			<c:when test="${pagination.nowPage==page }">
				<li class="page-item active"><a class="page-link" href="FindBoardListController.do?pageNo=${page }&id=${requestScope.marketVO.id }">${page }</a></li>				
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="FindBoardListController.do?pageNo=${page }&id=${requestScope.marketVO.id }">${page }</a></li>			
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${pagination.nextPageGroup }">
	  	<li class="page-item"><a class="page-link" href="FindBoardListController.do?pageNo=${pagination.endPageOfPageGroup+1 }&id=${requestScope.marketVO.id }">Next</a></li>     
	</c:if>		
</ul>





















