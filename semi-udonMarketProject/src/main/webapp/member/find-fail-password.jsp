<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	alert("정보를 다시 확인해주세요");
	location.href="${pageContext.request.contextPath}/FindPasswordFormController.do";
</script>