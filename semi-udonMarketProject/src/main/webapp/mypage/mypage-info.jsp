<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>회원정보</h1>
<c:import url="mypage/member-info.jsp"></c:import><br><br>
<c:if test="${sessionScope.mvo.memberType==1}">
  <h1>상점정보</h1>
  <c:import url="mypage/market-info.jsp"></c:import>
</c:if>