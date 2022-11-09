<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      

<form action="UpdateBoardController.do?board_No=${marketBoardVO.boardNo}&id=${requestScope.id }" method="post">
<table class="table">
	<thead>
		<tr>
			<td>글번호 ${marketBoardVO.boardNo}</td>
			<td>제목 <input type="text" name="title" value="${marketBoardVO.title }"></td>
			<td>조회수 ${marketBoardVO.hits}</td>
			<td>${marketBoardVO.timePosted}</td>
		</tr>
	</thead>
	<tbody style="center">
		<tr>
			<td colspan="4">
				<textarea rows="10" class="form-control" name="content" placeholder="본문내용" required="required">${requestScope.marketBoardVO.content }</textarea>
			</td>
		</tr>
	</tbody>
</table>
	<div align="center">
		<button type="submit" class="btn-lg btn btn-success">수정 완료</button>
		<a href="BoardDetailController.do?board_no=${marketBoardVO.boardNo}&id=${requestScope.id }"><button type="button" class="btn-lg btn btn-success">수정취소</button></a>
	</div>
</form>