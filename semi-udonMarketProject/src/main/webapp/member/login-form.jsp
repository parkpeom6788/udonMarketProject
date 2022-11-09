<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>로그인</h1>
<form action="${pageContext.request.contextPath}/LoginController.do" method="post">
	<input type="text" class="form-control-lg" name="id" placeholder="아이디" required="required"><br><br>
	<input type="password" class="form-control-lg" name="password" placeholder="패스워드" required="required"> <br><br>
	<button type="submit" class="btn-lg btn btn-success">로그인</button><br><br>
</form>
<a href="${pageContext.request.contextPath}/FindIdFormController.do"> &nbsp;&nbsp;아이디찾기&nbsp;&nbsp;</a>
<a href="${pageContext.request.contextPath}/FindPasswordFormController.do"> &nbsp;&nbsp;비밀번호찾기&nbsp;&nbsp;</a><br>
&nbsp;&nbsp;아직 회원이 아니신가요?&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/RegisterMemberFormController.do">회원가입</a>