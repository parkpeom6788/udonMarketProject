<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="updateMemberForm" action="${pageContext.request.contextPath}/UpdateMemberInfoController.do" method="post" onsubmit = "checkMemberTel(event)">
  <h1>회원정보수정</h1>
     <input type="hidden" name="memberId" value="${memberVO.id}">
  <table class="table table-bordered" style="border-width: 10px">
    <tr>  
      <td>패스워드</td><td><input class="form-control-lg" type="password" name="password" value="${memberVO.password}" required="required"></td>
    </tr>
    <tr>  
      <td>이름</td><td><input class="form-control-lg" type="text" name="name" value="${memberVO.name}" required="required"></td>
    </tr>
    <tr>
      <td>연락처</td>
      <td>
        <input class="form-control-lg" type="text" name="tel" id="memberTel" value="${memberVO.tel}" required="required">
      	&nbsp;&nbsp;11자리 입력하세요 (000-0000-0000 으로 작성하세요)
      </td>
    </tr>
  </table>
  <div class="text-center">
    <button type="submit" class="btn-lg">확인</button>
  </div>
</form>
<script type ="text/javascript">
  function checkMemberTel(event){
	let memberTel = document.getElementById("memberTel").value;
	  if(memberTel.length!=13){
		alert("전화번호를 다시 확인하세요");
		event.preventDefault();
		return;
	  }
	
	let result = confirm("수정을 완료하시겠습니까?");
	  if(result)
		document.getElementById("updateMemberForm").submit();
	  else
		event.preventDefault();
	  }
</script>