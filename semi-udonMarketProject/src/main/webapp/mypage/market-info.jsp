<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-bordered" style="border-width: 10px">
  <tr>
    <td>상점 이름</td><td>${requestScope.marketVO.marketName}</td>
  </tr>
  <tr>
    <td>상점 주소</td><td>${requestScope.marketVO.marketAddress}</td>
  </tr>
  <tr>
    <td>상점 전화번호</td><td>${requestScope.marketVO.marketTel}</td>
  </tr>
  <tr>
    <td>상점 품목</td><td>${requestScope.marketVO.item}</td>
  </tr>
  <tr>
    <td>상점 소개</td><td>${requestScope.marketVO.info}</td>
  </tr>
  <tr>
    <td>사업자등록번호</td><td>${requestScope.marketVO.marketNo}</td>
  </tr>
</table>
<div align="center">

<form action="UpdateMarketFormController.do" method ="get">
  <button type="submit" class="btn-lg">수정</button>
</form>

<a href="DeleteMarketController.do?no=${requestScope.marketVO.marketNo}" style="float: right;">
<input type="hidden" name="marketNo" value="${requestScope.marketVO.marketNo}">
<font size="5px">상점삭제</font></a>

</div>









