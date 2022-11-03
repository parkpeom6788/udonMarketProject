<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>회원정보</h3><br>
<c:import url="mypage/member-info.jsp"></c:import><br><br>
<c:if test="${sessionScope.mvo.memberType==1}">
  <h3>상점정보</h3><br>
  <c:import url="mypage/market-info.jsp"></c:import>
</c:if>