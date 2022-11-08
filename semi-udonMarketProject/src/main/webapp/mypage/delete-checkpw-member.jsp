<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>비밀번호 확인</h1>
<form action="${pageContext.request.contextPath}/DeleteMemberController.do" method="post" onsubmit="passCheck(event)">
  <input type="hidden" name="memberId" value="${sessionScope.mvo.id}">
  <input type="hidden" id="memberPw" value="${sessionScope.mvo.password}">
  <input type="password" class="form-control-lg" id="pw" name="password" placeholder="패스워드" required="required">
  <button type="submit">확인</button>
</form>
<script type ="text/javascript">
  function passCheck(event) {
	let pwCheck=document.getElementById("pw");
	let password=document.getElementById("memberPw").value;
	if(pwCheck.value!=password){
		alert("패스워드가 일치하지 않습니다");
		pwCheck.value = "";
		event.preventDefault();
		return;
	}
}
</script>