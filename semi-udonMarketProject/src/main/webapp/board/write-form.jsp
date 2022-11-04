<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" action="upload/test3.jsp" enctype="multipart/form-data">
		제목: <input type="text" name="subject" placeholder="파일 제목"/><br/>
		파일: <input type="file" name="upload"/>
		<button type="submit">전송</button>
</form>

<form method="post" action="WritePostController.do">
		<table class="table">
			<tr>
				<td><input type="text" name="title" placeholder="글제목" required="required"></td>
			</tr>
			<tr>
				<td><textarea rows="10" class="form-control" name="content" placeholder="본문내용" required="required"></textarea></td>
			</tr>
		</table>
		<div class="text-center">
			<button type="submit" class="btn btn-success">확인</button>
			<a href="index.jsp"><button type="button" class="btn btn-success">취소</button></a>
		</div>
</form>