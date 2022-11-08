<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<button type="submit" class="btn-lg" onclick="updateMarket()">수정</button>
	<a href="javascript:deleteMarket()" style="float: right;"><font size="5px">상점삭제</font></a>
</div>

<form id="updateMarketForm" action="UpdateMarketFormController.do" method="post">
	<input type="hidden" name="memberId" value="${sessionScope.mvo.id}">
</form>

<form id="deleteMarketForm" action="DeleteMarketController.do" method="post">
	<input type="hidden" name="no" value="${requestScope.marketVO.marketNo}">
	<input type="hidden" name="marketNo" value="${requestScope.marketVO.marketNo}">
</form>

<script>
	  function updateMarket() {
		if(confirm("상점정보를 수정하시겠습니까?")){
			document.getElementById("updateMarketForm").submit();
		}
	}
	function deleteMarket() {
		if(confirm("상점삭제 하시겠습니까?")){
			document.getElementById("deleteMarketForm").submit();
		}
	}
</script>



<%-- <div align="center">
	<form action="UpdateMarketFormController.do" method ="get">
		<button type="submit" class="btn-lg">수정</button>
	</form>

	<a href="javascript:deleteMarket()" style="float: right;">
		<font size="5px">상점삭제</font>
	</a>
</div>

<form id="deleteMarketForm" action="DeleteMarketController.do" method="post">
	<input type="hidden" name="no" value="${requestScope.marketVO.marketNo}">
	<input type="hidden" name="marketNo" value="${requestScope.marketVO.marketNo}">
</form>

<script type="text/javascript">
	function deleteMarket() {
		if(confirm("상점삭제 하시겠습니까?")){
			document.getElementById("deleteMarketForm").submit();
		}
	}
</script> --%>









