<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="${pageContext.request.contextPath}/RegisterMarketController.do" method="post" onsubmit="checkRegisterForm(event)">
  <input type="text" class="form-control-lg" name="id" readonly="readonly" value="${sessionScope.mvo.id}"><br><br>
  <input type="text" class="form-control-lg" name="marketName" placeholder="상점명" required="required"><br><br>
  <input type="text" class="form-control-lg" name="marketAddress" id="marketAddress" placeholder="상점주소" required="required"> <br><br>
  <input type="text" class="form-control-lg" name="marketTel" id="marketTel" placeholder="상점전화번호" required="required"> 11자리 입력하세요 (000-0000-0000 으로 작성하세요)<br><br>
    <input type="radio" name="info" id="info" value="과일" required="required" style="font-size:20pt ; width:30px;height:30px">과일
    <input type="radio" name="info" id="info" value="채소" required="required" style="font-size:20pt ; width:30px;height:30px">채소
    <input type="radio" name="info" id="info" value="수산물" required="required" style="font-size:20pt ; width:30px;height:30px">수산물 <br><br>
  <input type="text" class="form-control-lg" name="item" placeholder="상점소개글" required="required"><br><br>
  <input type="text" class="form-control-lg" name="marketNo" id="marketNo" placeholder="사업자등록번호" required="required" onkeyup="checkMarketNo()">
  (00000-00 형식을 지켜주세요)
  <span id="checkResultNo"></span><br><br>
  <button type="submit">상점등록</button>
</form>
<script type="text/javascript">

  let checkFlag=false;
  
  function checkRegisterForm(event) {
	  
	  let marketAddress = document.getElementById("marketAddress").value;
	  let marketTel = document.getElementById("marketTel").value;
	  let info = document.getElementById("info").value;
	  let addressCheck = "판교";
	  
		if(marketAddress != addressCheck){
			alert("상점 주소지가 판교가 아니면 가입이 불가합니다");
			event.preventDefault();
			return;
		}
		
		if(marketTel.length!=13){
			alert("전화번호를 다시 확인하세요");
			event.preventDefault();
			return;
		}
	  
	  
	if(checkFlag==false){
		alert("상점 등록 정보를 확인해주세요");
		Event.preventDefault();
	}
}
  function checkMarketNo(){
	  checkFlag=false;
	  let xhr = new XMLHttpRequest();
	  let marketNo = document.getElementById("marketNo").value;
	  let checkMarketNo = document.getElementById("checkResultNo");
	  
	  if(marketNo.length != 8){
		  checkMarketNo.innerHTML = "사업자 번호는 8자 입니다";
	  }else{
		  xhr.onreadystatechange=function(){
			  if(xhr.readyState==4&&xhr.status==200){
				  if(xhr.responseText=="ok"){
					  checkMarketNo.innerHTML = "사용가능한 사업자번호입니다";
					  checkFlag = true;
				  }else{
					  checkMarketNo.innerHTML = "사업자번호가 중복됩니다";
				  }
			  }
		  }
		  xhr.open("get","${pageContext.request.contextPath}/CheckMarketNoController.do?marketNo="+marketNo);
		xhr.send();
	  }
  }
</script> 















