<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<h4>찾으시는 아이디는 ' ${requestScope.vo.id} ' 입니다</h4>

<form action="${pageContext.request.contextPath}/LoginFormController.do" method="post" ><br><br>
<button type="submit" class = "btn">로그인폼으로..</button>
</form>