<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0",maximum-scale=1.0, user-scalable=no">
<title>설비 고장신고 게시판</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>

  
<script type="text/javascript">
	$(document).ready(function(){
		$("#regBtn").click(function(){
			location.href="boardInsert"
		})
		$("#pageSize").val("${sch.pageSize}")	
		$("#schBtn").click(function(){
			$("[name=curPage]").val(1)
			$("form").submit();			
		})
	});
	function goDetail(no){
		location.href="boardDetail?no="+no
	}	
	function goPage(pcnt){
		$("[name=curPage]").val(pcnt) // 클릭한 번호를 현재 페이지로 설정하고..
		$("form").submit()  // 요청값으로 전송 처리..
	}
  	function uptPageSize(){
		$("[name=pageSize]").val($("#pageSize").val())
		$("[name=curPage]").val(1)
		$("form").submit();
  	}
  	function chat(){
  		location.href="chatting"
  	}
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h1>설비 고장신고 게시판</h1>
  <h7>설비에 문제가 있을 시 아래 게시판에 남겨주세요.</h7>
</div>
<div class="container">

	<form id="frm01" class="form"  method="post">
		<input type="hidden" name="curPage" value="${sch.curPage}"/>
		<input type="hidden" name="pageSize" value="${sch.pageSize}"/>
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="제목" name="subject"  value="${param.subject}" class="form-control mr-sm-2" />
	    <input placeholder="작성자" name="writer" value="${param.writer}" class="form-control mr-sm-2"/>
	    <button class="btn btn-info" type="button" id="schBtn">Search</button>
	    <button class="btn btn-success" id="regBtn" type="button">등록</button>
 	</nav>
	</form>

<div class="container-fluid">
  <div class="row">
    <div class="col-sm-1" style="padding-left:0;">
       
       <select class="form-control"  id="pageSize" onchange="uptPageSize()" style="width:100px;">
	    <option value="3">3 개씩</option>
	    <option value="5">5 개씩</option>
	    <option value="10">10 개씩</option>
	    <option value="20">20 개씩</option>
	    <option value="50">50 개씩</option>
	  </select>  
    </div>
    <div class="col-sm-11" ></div>
  </div>
</div>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
    </thead>	
    <tbody>
    	<c:forEach var="bd" items="${boardList}">
    	<tr ondblclick="goDetail(${bd.no})"><td>${bd.cnt}</td>
    		<td style="text-align:left;">
    		<c:if test="${bd.level >= 2}">
    			<c:forEach begin="2" end="${bd.level}" varStatus="sts">
        		&nbsp;&nbsp;&nbsp;
        	<c:if test="${sts.last}">☞</c:if>
    			</c:forEach>
			</c:if>
    		${bd.subject}</td><td>${bd.writer}</td>
    		<td><fmt:formatDate value="${bd.regdte}"/></td><td>${bd.readcnt}</td></tr>
    	</c:forEach>
    </tbody>
	</table> 
	
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3" style="padding-left: 0;">
      <button type="button" class="btn btn-primary">
		  총 <span class="badge badge-light">${sch.count}</span> 건
	   </button>
	   <button class="btn btn-danger" id="regBtn" type="button" onclick="chat()" >1:1 관리자 채팅</button>
    </div>
    <div class="col-sm-4">
    	
    </div>
    <div class="col-sm-5" >
		<ul class="pagination justify-content-end" >
		  <li class="page-item"><a class="page-link" href="javascript:goPage(${sch.startBlock-1})">Previous</a></li>	  
		  <c:forEach var="pcnt" begin="${sch.startBlock < 0 ? 0 : sch.startBlock}" end="${sch.endBlock}">
		  	<li class="page-item ${sch.curPage==pcnt?'active':''}">
		  		<a class="page-link" href="javascript:goPage(${pcnt})">${pcnt}</a></li>
		  </c:forEach>
		  <!-- 
		  	클릭한 현재페이지 번호와 페이지번호가 같을 때, 배경색상이 있게(active) 처리함..
		   -->
		  <li class="page-item"><a class="page-link" href="javascript:goPage(${sch.endBlock+1})">Next</a></li>
		</ul>    
    </div>
  </div>
</div>
</div>
</body>
</html>