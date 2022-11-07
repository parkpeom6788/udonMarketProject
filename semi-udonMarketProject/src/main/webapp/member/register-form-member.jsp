<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>회원가입</h1>
<form action="${pageContext.request.contextPath}/RegisterMemberController.do" method="post" onsubmit="check(event)">
	<input class="form-control-lg" type="text" name="id" id="id" placeholder="아이디" required="required" onkeyup="checkId()"> 4자 이상 입력하세요
	<span id = "checkResultId"></span><br><br>
	<input class="form-control-lg" type="password" id="password" name="password" placeholder="비밀번호" required="required" > 5자 이상 입력하세요<br><br>
	<input class="form-control-lg" type="password" id="passwordcheck" name="passwordcheck" placeholder="비밀번호확인" required="required"><br><br>
	<input class="form-control-lg" type="text" name="name"  placeholder="이름" required="required"><br><br>
	<input class="form-control-lg" type="text" name="no"  id = "no" placeholder="주민번호" required="required"> 9자리 입력하세요 (000000-000 으로 작성하세요)<br><br>
	<input class="form-control-lg" type="text" name="address" id="address" placeholder="주소" required="required"><br><br>
	<input class="form-control-lg" type="text" name="tel" id = "tel"  placeholder="전화번호" required="required"> 11자리 입력하세요 (000-0000-0000 으로 작성하세요)<br><br>
	<button type="submit" class="btn-lg">회원가입</button>
</form>

<script type="text/javascript">

let checkFlag = false;

function check(event){
	let password = document.getElementById("password").value;
	let passwordcheck = document.getElementById("passwordcheck").value;
	let no = document.getElementById("no").value;
	let tel = document.getElementById("tel").value;
	let address = document.getElementById("address").value;
	let addressCheck = "판교";
	
	if(password.length!=5){
		alert("비밀번호는 5자 이상이여야합니다");
		event.preventDefault();
		return;
	}
	
	if(password != passwordcheck){
			alert("비밀번호가 일치하지않습니다");
			event.preventDefault();
			return;
	}
	if(no.length!=10){
		alert("주민번호 9자리를 입력하세요");
		event.preventDefault();
		return;
	}
	if(address != addressCheck){
		alert("판교 주민이 아니면 가입이 불가합니다");
		event.preventDefault();
		return;
	}
	if(tel.length!=13){
		alert("전화번호를 다시 확인하세요");
		event.preventDefault();
		return;
	}
	if(checkFlag==false){
		alert("회원가입에 실패했습니다");
		event.preventDefault();
		}
	}

function checkId(){
	checkFlag=false;
	let xhr = new XMLHttpRequest();
	let id = document.getElementById("id").value;
	let checkResultId = document.getElementById("checkResultId");
	
	if(id.length<4){
		checkResultId.innerHTML="아이디는 4자 이상이여야 합니다";
	}else{
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				if(xhr.responseText=="ok"){
				checkResultId.innerHTML="사용가능한 아이디입니다";
				checkFlag=true;
				}else{
				checkResultId.innerHTML="아이디가 중복됩니다";
				}
			}
		}
	xhr.open("get","${pageContext.request.contextPath}/CheckIdController.do?id="+id);
	xhr.send();
	}
}

</script>
