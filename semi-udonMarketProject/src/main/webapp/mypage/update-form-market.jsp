<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>마켓 수정</h1>
<form id = "updateForm" action="${pageContext.request.contextPath}/UpdateMarketController.do" method="post" onsubmit = "checkTel(event)" >
	<table class ="table">
		<tr>
			<th>상점명 </th>
			<th><input class="form-control-lg" type="text" name="marketName" value ="${requestScope.marketVO.marketName}" required="required" > </th>
		</tr>
		 <tr>
			<th>상점전화번호 </th>
			<th><input class="form-control-lg" type="text"  name="marketTel" id ="marketTel" value= "${requestScope.marketVO.marketTel}"required="required" > </th>
			<th> 11자리 입력하세요 (000-0000-0000 으로 작성하세요)</th>
		 </tr>
		 <tr>
			<th>상점소개</th>
			<th> <input class="form-control-lg" type="text"  name="marketInfo" value="${requestScope.marketVO.info}" required="required" ></th>
		</tr>
	</table>
	 <button >수정완료</button>
 </form>
 
<script type ="text/javascript">
	function checkTel(event){
		let marketTel = document.getElementById("marketTel").value;
		if(marketTel.length!=13){
			alert("전화번호를 다시 확인하세요");
			event.preventDefault();
			return;
		}
	
		let result = confirm("수정을 완료하시겠습니까 ? ");
		if(result)
			document.getElementById("updateForm").submit();
		else
			event.preventDefault();
	}
</script>
