<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>' ${requestScope.vo.id} ' 아이디의 비밀번호는  ' ${requestScope.vo.password} ' 입니다</h1>
<form action="${pageContext.request.contextPath}/LoginFormController.do" method="post" ><br><br>
	<button type="submit" class = "btn">로그인폼으로..</button>
</form>
        
        