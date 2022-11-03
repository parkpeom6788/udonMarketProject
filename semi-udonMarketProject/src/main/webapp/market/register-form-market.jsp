<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="${pageContext.request.contextPath}/RegisterMarketController.do" method="post" onsubmit="checkRegisterForm(event)">
  <input type="text" class="form-control-lg" name="id" readonly="readonly" value="${sessionScope.mvo.id}"><br><br>
  <input type="text" class="form-control-lg" name="marketName" placeholder="상점명" required="required"><br><br>
  <input type="text" class="form-control-lg" name="marketAddress" placeholder="상점주소" required="required"><br><br>
  <input type="text" class="form-control-lg" name="marketTel" placeholder="상점전화번호" required="required"><br><br>
  <input type="text" class="form-control-lg" name="info" placeholder="상점품목" required="required"><br><br>
  <input type="text" class="form-control-lg" name="item" placeholder="상점소개글" required="required"><br><br>
  <input type="text" class="form-control-lg" name="marketNo" placeholder="사업자등록번호" required="required" onkeyup="checkMarketNo">
  <span id="checkResult"></span><br><br>
  <button type="submit">상점등록</button>
</form>
<!-- <script type="text/javascript">
  let checkFlag=false;
  function checkRegisterForm(event) {
	if(checkFlag==false){
		alert("상점 등록 정보를 확인해주세요");
		Event.preventDefault();
	}
}
</script> -->