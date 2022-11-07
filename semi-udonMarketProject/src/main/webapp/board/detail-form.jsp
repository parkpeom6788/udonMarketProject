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
					<c:if test="${requestScope.vo.imageName != null }">
						<img src="saveData/${requestScope.vo.imageName }" width="250" height="250">
					</c:if>
					${requestScope.vo.content}
			</td>
		</tr>
		<tr align="center">
			<td>
					<a href="FindBoardListController.do?id=${requestScope.id }"><button type="button">뒤로가기</button></a>
			<c:if test="${sessionScope.memberVO.id == requestScope.id }">
						<button type="button" onclick="deletePost()">삭제</button>			
						<button type="button" onclick="updatePost()">수정</button>	
			</c:if>	
			</td>
		</tr>
	</tbody>
	<!-- 좋아요 부분 -->
	<tfoot>
			<tr>
				<td>
					<button type="button" onclick=checkLove2()>♡</button>
					<span id="checkResult">${requestScope.count}</span>
				</td>
			</tr>
	</tfoot>		
	<!-- 좋아요 부분   -->
</table>
		
		<form id="deleteForm" action="DeleteBoardController.do?id=${requestScope.id }" method="post">
			<input type="hidden" name="board_no" value="${requestScope.vo.boardNo}">
		</form>
	
		<form id="updateForm" action="UpdateBoardFormController.do?id=${requestScope.id }" method="post">
			<input type="hidden" name="board_no" value="${requestScope.vo.boardNo}">
		</form>
		
	<script type="text/javascript">
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
	
	<script type="text/javascript">
		function checkLove2() {
			alert("하이");
			
			let checkResultSpan = document.getElementById("checkResult");
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {				
					if(xhr.readyState == 4 && xhr.status == 200) {
						let message = xhr.responseText;
						if(message == "ok") {
							checkResultSpan.innerHTML = "<font color=red>♥</font>";
						} else {
							checkResultSpan.innerHTML = "<font color=white>♡</font>";
							}
						}
				}
				xhr.open("get","CheckLoveController.do?id="${requestScope.id}"&board_no="${requestScope.vo.boardNo});
				xhr.send();
			}
		}
	</script>
	<br>
	<c:import url="/comment/comment.jsp"></c:import>