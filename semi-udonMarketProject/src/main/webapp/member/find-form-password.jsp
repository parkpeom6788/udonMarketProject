<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>비밀번호 찾기</h1>
<form action="${pageContext.request.contextPath}/FindPasswordController.do" method="post" onsubmit="check(event)">
	<input class="form-control-lg" type="text" name="id"  placeholder="아이디" required="required"><br><br>
	<input class="form-control-lg" type="text" name="name"  placeholder="이름" required="required"><br><br>
	<input class="form-control-lg" type="text" name="no"  id = "no" placeholder="주민번호" required="required"> 9자리 입력하세요 (000000-000 으로 작성하세요)<br><br>
	<input class="form-control-lg" type="text" name="tel" id = "tel"  placeholder="전화번호" required="required"> 11자리 입력하세요 (000-0000-0000 으로 작성하세요)<br><br>
	<button type="submit" class="btn-lg btn btn-success">비밀번호 찾기</button>
</form>

<script type="text/javascript">
	function check(event){
		let no = document.getElementById("no").value;
		let tel = document.getElementById("tel").value;
		
		if(no.length!=10){
			alert("주민번호 9자리를 입력하세요");
			event.preventDefault();
			return;
		}
		
		if(tel.length!=13){
			alert("전화번호를 다시 확인하세요");
			event.preventDefault();
			return;
		}
	}
</script>