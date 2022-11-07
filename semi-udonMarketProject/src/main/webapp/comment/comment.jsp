<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      

<p>상점 후기</p>
<table id="comment" class="table">
	<c:forEach items="${requestScope.commentList }" var="list" varStatus="order">
		<tr>
			<td class="comList">
				${list.id }<br>${list.commentContent }<br>${list.commentTimePosted }&nbsp;&nbsp;
				<c:if test="${sessionScope.mvo.id==list.id }">
					<span onclick="commentUpdate(${order.index })" style="cursor: pointer" class="text-primary" >수정</span>
					<span onclick="commentDelete(${list.commentNo})" style="cursor: pointer" class="text-secondary" >삭제</span>
				</c:if>
				<div id="comDiv" style="display: none">
					${sessionScope.mvo.id }<br>
					<input type="text" id="newContent" style="width: 700px; height: 50px" placeholder="수정할 내용을 작성해주세요">
					<button type="button" style="width: 50px" onclick="updateComment(${list.commentNo})">수정</button>
					<button type="button" style="width: 50px" onclick="cancleUpdate()">취소</button>
				</div>				
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td id="comWrite">
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
				commentContent.value="";
				location.reload();
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
	
	function commentUpdate(index){
		let comList = document.getElementsByClassName("comList");
		let comDiv = document.getElementById("comDiv");
		comList[index].innerHTML = comDiv.innerHTML;
		
		let comWrite = document.getElementById("comWrite");
		comWrite.style.display = "none";
	}
	
	function updateComment(commentNo){
		let newContent = document.getElementById("newContent");
		if(newContent.value.trim()==""){
			alert("수정할 내용을 작성해주세요");
			newContent.focus();
			return;
		}
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){	
			if(xhr.readyState==4&&xhr.status==200){
				location.reload();
			}
		}
		xhr.open("post","UpdateCommentController.do");
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.send("commentNo="+commentNo+"&content="+newContent.value);
	}
	function cancleUpdate(){
		let result = confirm("수정을 취소하시겠습니까?");
		if(result==true)
			location.reload();
	}
</script>


