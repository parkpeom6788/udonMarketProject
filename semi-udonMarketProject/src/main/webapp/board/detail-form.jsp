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
				<!-- <pre style="font-family: 'Jua', sans-serif"><font size="4"> -->
					<c:if test="${requestScope.vo.imageName != null }">
						<img src="saveData/${requestScope.vo.imageName }" width="250" height="250">
					</c:if>
					${requestScope.vo.content}

				<!-- </font> -->
				<!-- </pre> -->
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
				<span id="checkResult"><input type="button" value="♡" id="heart" onclick="checkLove()"/></span>
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
	<script>

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

		/* ajax 좋아요 부분 */
		function checkLove() {
			let checkFlag = false;

			
			let heart = document.getElementById("heart").value; // 하트값 

			let heart = document.getElementById("heart").value; //하트값 ♡

			let checkResultSpan = document.getElementById("checkResult");

			
			out.print("uihiuhuihiuhui"); // false가 옴 
					
			let xhr = new XMLHttpRequest();	
			xhr.onreadystatechange = function() {								

		
			let xhr = new XMLHttpRequest();
				
				xhr.onreadystatechange = function() {				
				

				if(xhr.readyState == 4 && xhr.status == 200) {

					if(xhr.responseText == "ok") {
						checkResultSpan.innerHTML = "<font color=red>♥</font>";

					let message = xhr.responseText;
					alert("좋아요를 클릭하셨습니다.");
					if(message == "ok") {
						checkResultSpan.innerHTML = "<img src=img/hart1.png>";

						checkFlag = true;

					} else {
						checkResultSpan.innerHTML = "<font color=white>♡</font>";
					}

			} else {
				checkResultSpan.innerHTML = "<img src=img/hart2.png width=150px height=150px>";
				checkFlag = false;

				}
			}
			xhr.open("get","CheckLoveController.do?checkFlag="+checkFlag);
			xhr.send();
		}
			xhr.open("get","CheckLoveController.do?heart="+heart);
			xhr.send();
		}
		/* ajax 좋아요 부분 */

	</script>
	<br>
	<c:import url="/comment/comment.jsp"></c:import>
	


