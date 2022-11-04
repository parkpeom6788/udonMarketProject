<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="UpdateMemberInfoController.do" method="post">
  <h1>회원정보수정</h1>
     <input type="hidden" name="memberId" value="${memberVO.id}">
  <table class="table table-bordered" style="border-width: 10px">
    <tr>  
      <td>패스워드</td><td><input type="password" name="password" value="${memberVO.password}" required="required"></td>
    </tr>
    <tr>  
      <td>이름</td><td><input type="text" name="name" value="${memberVO.name}" required="required"></td>
    </tr>
    <tr>
      <td>연락처</td><td><input type="text" name="tel" value="${memberVO.tel}" required="required"></td>
    </tr>
  </table>
  <div class="text-center">
    <button type="submit" class="btn-lg">확인</button>
    <button type="reset" class="btn-lg">취소</button>
  </div>
</form>