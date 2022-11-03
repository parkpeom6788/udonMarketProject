<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-bordered">
<tr>
  <td>아이디</td><td>${sessionScope.mvo.id}</td>
</tr>
<tr>
  <td>비밀번호</td><td>${sessionScope.mvo.password}</td>
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
<form action="" method="post">
  <button type="submit" class="btn-lg">수정</button>
</form>
&nbsp;&nbsp;<a href="">회원탈퇴</a>