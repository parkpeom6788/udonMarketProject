<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<table class="table">
	<tr>
		<td>글번호 ${requestScope.vo.boardNo}</td>
		<td>제목 ${requestScope.vo.title}</td>
		<td>조회수 ${requestScope.vo.hits}</td>
		<td>${requestScope.vo.timePosted}</td>
	</tr>

	<tbody>
		<tr>
			<td colspan="4">
				<pre style="font-family: 'Jua', sans-serif"><font size="4">${requestScope.vo.content}</font></pre>
	<%-- 			 <pre>
					<c:if test="${requestScope.filename1 != null}">
				 		<font size="4">${requestScope.vo.content}</font>
				 	</c:if>
				 	<c:otherwise>
				 		<font size="4">${requestScope.vo.content}</font>
				 	</c:otherwise>	
				 </pre> --%>
			</td>
		</tr>
	</tbody>
</table>

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
		function writeComment(event){
			let content = document.getElementById("content").value.trim();
			if(content==""){
				alert("상점 후기를 입력해주세요");
				event.preventDefault();
				return;
			}
			document.getElementById("content").submit();
		}
	</script>
	
	<br><p>상점 후기</p>
	<table id="comment" class="table">
		<c:forEach items="${requestScope.commentList }" var="list">
			<tr>
				<td>${list.id }<br>${list.commentContent }<br>${list.commentTimePosted }</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<table>
					<tr>
						${sessionScope.mvo.id }<br>
						<form id="contentForm" action="WriteCommentController.do" method="post" onsubmit="writeComment(event)">
							<input id="content" name="commentContent" style="width: 750px; height: 60px" placeholder="상점 후기를 남겨주세요">
							<input type="hidden" name="boardNo" value="${requestScope.vo.boardNo}">
							<input type="hidden" name="id" value="${sessionScope.mvo.id}">
							&nbsp;&nbsp;<button type="button" onclick="writeComment()" style="width: 60px">등록</button>
						</form>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
