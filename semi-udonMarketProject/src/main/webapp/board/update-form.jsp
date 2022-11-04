<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      

<form action="UpdateBoardController.do?board_No=${marketBoardVO.boardNo}" method="post">
<table class="table">
		<tr>
			<td>글번호 ${marketBoardVO.boardNo}</td>
			<td>제목 <input type="text" name="title" value="${marketBoardVO.title }"></td>
			<td>조회수 ${marketBoardVO.hits}</td>
			<td>${marketBoardVO.timePosted}</td>
		</tr>
		<tbody style="center">
		<tr>
		<td colspan="5">
			 <pre>
		 		<font size="5">
		 			<input type="text" name="content" value="${requestScope.marketBoardVO.content }">
		 		</font>
		 	</pre>
		</td>
	</tr>
	</tbody>
</table>
	<button type="submit">수정 완료</button>
	<button type="submit">수정 취소</button>
</form>