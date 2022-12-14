<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <div class="container-fluid p-0 mb-5 wow fadeIn" data-wow-delay="0.1s">
        <div id="header-carousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="w-100" src="img/carousel-1.jpg" alt="Image">
                    <div class="carousel-caption">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-lg-7">
                                    <h1 class="display-2 mb-5 animated slideInDown">Hello 우동마켓</h1>
									<form id="inputSearchForm" action="FindMarketByNameController.do" method="get" onsubmit="searchForm(event)">
                                   		<input id="inputSearch" class="input-search form-control-lg" name="searchInfo" placeholder="상점이름을 검색하세요">
                               			<button type="submit" class="btn-lg"><small class="fa fa-search text-body"></small></button>
                                   	</form>
                                    <script type="text/javascript">
                                    	function searchForm(event){
                                    		let inputSearchForm = document.getElementById("inputSearchForm");
                                    		let inputSearch = document.getElementById("inputSearch");
                                    		if(inputSearch.value.trim()==""){
                                    			alert("검색어를 입력하세요");
                                    			inputSearch.value = "";
                                    			event.preventDefault();
                                    			return;
                                    		}
                                    	}
                                    </script>
                                    <br>
                                    <a href="FindMarketListSortByItemController.do?item=과일" class="btn btn-primary rounded-pill py-sm-3 px-sm-5">과일</a>
                                    <a href="FindMarketListSortByItemController.do?item=채소" class="btn btn-secondary rounded-pill py-sm-3 px-sm-5 ms-3">채소</a>
                                    <a href="FindMarketListSortByItemController.do?item=수산물" class="btn btn-info rounded-pill py-sm-3 px-sm-5 ms-3">수산물</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>