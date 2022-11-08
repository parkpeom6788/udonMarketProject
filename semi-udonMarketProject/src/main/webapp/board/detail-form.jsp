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
						<br>
						<img src="saveData/${requestScope.vo.imageName }" width="800" height="500">
					</c:if>
					<div>
						<br>
						${requestScope.vo.content}				
					</div>
			</td>
		</tr>
		<tr>
			<td align="left">
				<a href="FindBoardListController.do?id=${requestScope.id }">뒤로가기</a>
			</td>
			<td colspan="3" align="right">
				<c:if test="${sessionScope.memberVO.id == requestScope.id }">
					<button type="button" onclick="updatePost()">수정</button>	
					<button type="button" onclick="deletePost()">삭제</button>			
				</c:if>	
			</td>
		</tr>
	</tbody>
	<!-- 좋아요 부분 -->
	<tfoot>
			<tr>
				<td>
					<span id="heartSpan" style="cursor: pointer;" onclick="checkHeart(${requestScope.vo.boardNo})">
						<c:choose>
							<c:when test="${requestScope.heart==false }">
								<font color="red">♡</font>							
							</c:when>
							<c:otherwise>
								<font color="red">♥</font>		
							</c:otherwise>
						</c:choose>
					</span>
					<span id="heartCount">${requestScope.count}</span>
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
		
	function checkHeart(boardNo){
		let heartSpan = document.getElementById("heartSpan");
		let heartCount = document.getElementById("heartCount");

		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState ==4 && xhr.status ==200){
				let result = JSON.parse(xhr.responseText);
				if(result.message == "ok"){
					heartSpan.innerHTML = "<font color=red>♥</font>";
				}
				else{
					heartSpan.innerHTML = "<font color=red>♡</font>";
				}
				heartCount.innerHTML = result.totalCount;
			}
		}
		xhr.open("get", "CheckLoveController.do?board_no="+boardNo);
		xhr.send();
	}	
	</script>	
	<br>
	<c:import url="/comment/comment.jsp"></c:import>