<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      

<p>상점 후기</p>
<table id="comment" class="table">
	<c:forEach items="${requestScope.commentList }" var="list">
		<tr>
			<td>
				${list.id }<br>${list.commentContent }<br>${list.commentTimePosted }&nbsp&nbsp
				<c:if test="${sessionScope.mvo.id==list.id }">
					<span onclick="commentDelete()" style="cursor: pointer" class="text-primary" >수정</span>
					<span onclick="commentDelete(${list.commentNo})" style="cursor: pointer" class="text-secondary" >삭제</span>
				</c:if>				
			</td>
		</tr>
	</c:forEach>
	<tr id="commentView"></tr>
	<tr>
		<td>
			${sessionScope.mvo.id }<br>
			<input type="text" id="commentContent" style="width: 750px; height: 50px" placeholder="상점 후기를 작성해주세요">
			<button type="button" style="width: 70px" onclick="writeComment()">등록</button>
		</td>
	</tr>
</table>
<script>
	function writeComment(){
		let commentContent = document.getElementById("commentContent");
		if(commentContent.value.trim()==""){
			alert("상품 후기를 작성해주세요");
			commentContent.focus();
			return;
		}
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){	
			if(xhr.readyState==4&&xhr.status==200){
				let comment = JSON.parse(xhr.responseText);
				let data = "<td>"+comment.id+"<br>"+comment.commentContent+"<br>"+comment.commentTimePosted+"</td>";
				document.getElementById("commentView").innerHTML = data;
				commentContent.value="";
			}
		}
		xhr.open("post","WriteCommentController.do");
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.send("boardNo=${requestScope.vo.boardNo}&id=${sessionScope.mvo.id}&content="+commentContent.value);
	}
	
	function commentDelete(commentNo){
		let result = confirm("상점 후기를 삭제하시겠습니까?");
		if(result==true){
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){	
				if(xhr.readyState==4&&xhr.status==200){
					location.reload();
				}
			}
			xhr.open("get","DeleteCommentController.do?commentNo="+commentNo+"&boardNo="+${requestScope.vo.boardNo});
			xhr.send();
		}
	}
</script>























