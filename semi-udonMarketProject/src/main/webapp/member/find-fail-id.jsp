<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	alert("찾으시는 아이디 정보가 없습니다");
	location.href="${pageContext.request.contextPath}/FindIdFormController.do";
</script>