<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	 <div class="section-header text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
	     <h1 class="display-5 mb-3">All Market</h1>
	 </div>
	 <div class="row g-4">
	 	<c:forEach items="${requestScope.marketList }" var="list">
		    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
		         <div class="bg-white text-center h-100 p-4 p-xl-5">
		             <img class="img-fluid mb-4" src="img/icon-1.png" alt="">
		             <h4 class="mb-3" font-family="'Jua', sans-serif">${list.marketName }</h4>
		             <p class="mb-4">${list.info }</p>
		             <a class="btn btn-outline-primary border-2 py-2 px-4 rounded-pill" href="FindBoardListController.do?id=${list.id }">View More</a>
		         </div>
		     </div>
	     </c:forEach>
	 </div>
