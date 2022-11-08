<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid fixed-top px-0 wow fadeIn" data-wow-delay="0.1s">
	<nav class="navbar navbar-expand-lg navbar-light py-lg-0 px-lg-5 wow fadeIn" data-wow-delay="0.1s">
		<a href="index.jsp" class="navbar-brand ms-4 ms-lg-0">
			<h1 class="fw-bold text-dark m-0"><span class="text-primary">우</span><small>리</small><span class="text-secondary">동</span><small>네</small>마켓</h1>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
            	<c:if test="${sessionScope.mvo!=null}">
	          	  	<c:choose>
	          	    	<c:when test="${sessionScope.mvo.memberType==1}">
	                    	<a href="FindBoardListController.do?id=${sessionScope.mvo.id }" class="nav-item nav-link text-secondary">상점주인</a>
	          	      		<a href="MypageFormController.do" class="nav-item nav-link text-primary">마이페이지</a>
	              	 		 <a href="WriteBoardFormController.do" class="nav-item nav-link">글쓰기</a>
						</c:when>
						<c:otherwise>
							<a href="MypageFormController.do" class="nav-item nav-link text-primary">동네주민</a>
							<a href="RegisterMarketFormController.do" class="nav-item nav-link">상점등록</a>
						</c:otherwise>
	                </c:choose>
	                <a class="nav-item nav-link">${sessionScope.mvo.name}님</a>
	                <a href="javascript:logout()" class="nav-item nav-link">로그아웃</a>
	                <form id="logoutForm" action="LogoutController.do" method="post"></form>
	          		<script type="text/javascript">
	           	 		function logout() {
	  						if(confirm("로그아웃 하시겠습니까?")){
	    						document.getElementById("logoutForm").submit();
	  						}
						}
	           		</script>
              </c:if>
          </div>
          <c:if test="${sessionScope.mvo==null}">
	          <div class="d-none d-lg-flex ms-2">
	              <a class="btn-sm-square bg-white rounded-circle ms-3" href="LoginFormController.do">
	                  <small class="fa fa-user text-body"></small>
	              </a>
	          </div>
          </c:if>
        </div>
    </nav>
</div>