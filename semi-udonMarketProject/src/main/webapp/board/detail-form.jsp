<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container pt-3">
<table class="table">
		<tr>
			<td>글번호 ${requestScope.vo.boardNo}</td>
			<td>제목 ${requestScope.vo.title}</td>
			<td>조회수 ${requestScope.vo.hits}</td>
			<td>${requestScope.vo.timePosted}</td>
		</tr>
		<tbody style="center">
		<tr>
		<td colspan="5">
			 <pre>
		 		<font size="4">${requestScope.vo.content}</font>
		 	</pre>
		</td>
	</tr>
	</tbody>
</table>
</div>
	<div align="center">
		<button type="button" onclick="deletePost()">삭제</button>			
		<button type="button" onclick="updatePost()">수정</button>	
	</div>
	
	<form id="deleteForm" action="DeleteBoardController.do" method="post">
		<input type="hidden" name="board_no" value="${requestScope.vo.boardNo}">
	</form>
	
	<form id="updateForm" action="UpdateBoardFormController.do" method="post">
		<input type="hidden" name="board_no" value="${requestScope.vo.boardNo}">
	</form>
	<script>
		function deletePost() {
			if(confirm("삭제하시겠습니까?")) {
				document.getElementById("deleteForm").submit();
			}
		}
		function updatePost() {
			if(confirm("수정하시겠습니까?")) {
				document.getElementById("updateForm").submit();
			}
		}
	</script>
</body>
</html>