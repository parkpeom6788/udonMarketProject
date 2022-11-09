<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-bordered" style="border-width: 10px">
	<tr>
		<td>아이디</td><td>${sessionScope.mvo.id}</td>
	</tr>
	<tr>
		<td>이름</td><td>${sessionScope.mvo.name}</td>
	</tr>
	<tr>
		<td>주민등록번호</td><td>${sessionScope.mvo.memberNo}</td>
	</tr>
	<tr>
		<td>주소</td><td>${sessionScope.mvo.address}</td>
	</tr>
	<tr>
		<td>연락처</td><td>${sessionScope.mvo.tel}</td>
	</tr>
</table>

<div align="center">
	<button type="submit" class="btn-lg btn btn-success" onclick="updateMember()">수정</button>
	<a href="javascript:deleteMember()" style="float: right;"><font size="5px">회원탈퇴</font></a>
</div>

<form id="updateMemberForm" action="UpdateMemberInfoFormController.do" method="post">
	<input type="hidden" name="memberId" value="${sessionScope.mvo.id}">
</form>

<form id="deleteMemberForm" action="DeleteMemberFormController.do" method="post">
	<input type="hidden" name="memberId" value="${sessionScope.mvo.id}">
</form>

<script>
  function updateMember() {
	if(confirm("회원정보를 수정하시겠습니까?")){
		document.getElementById("updateMemberForm").submit();
	}
}
  function deleteMember() {
	if(confirm("회원탈퇴 하시겠습니까?")){
		document.getElementById("deleteMemberForm").submit();
	}
}
</script>
