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
<title>1:1 관리자 채팅</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style type="text/css">
	.input-group-text{width:100%;background-color:linen;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:scroll;text-align:left;
		border:1px solid green;
		padding-right:15px;
	}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">

	var socketServer = "${socketServer}"
	//alert(socketServer+":접속")
	var wsocket = null
	$(document).ready(function(){
		
		$("#chatMessageArea").html("<strong>안녕하세요, 관리자입니다. 문의사항을 남겨주세요.</strong><br>");
		
		
		$("#enterBtn").click(function(){
			//alert(socketServer)
			  $("#chatMessageArea").html("");
				wsocket = new WebSocket(socketServer)
			    //alert(wsocket)
				wsocket.onopen=function(evt){
					console.log(evt)
					//alert($("#id").val()+"님:입장합니다.");
				
					wsocket.send( $("#id").val()+"님: 입장합니다.");
				}
				wsocket.onmessage = function(evt){
					//alert(evt.data)
					$("#chatMessageArea").append(evt.data+"<br>")
					if (evt.data.includes("님: 입장합니다.")) {
        				alert(evt.data); // 알림 띄우기
    					}
				}
		})
		$("#exitBtn").click(function(){
			alert($("#id").val()+"님:접속 종료합니다.")
			wsocket.send( $("#id").val()+"님:접속 종료합니다.");
			wsocket.close();
			$("#chatMessageArea").text("")
			$("#id").val("").focus()
		})
		$("#sendBtn").click(function(){
			sendMsg()
		})
		$("#msg").keyup(function(){
			if(event.keyCode==13){
				sendMsg()
			}
		})
	});
	function sendMsg(){
		wsocket.send( $("#id").val()+": "+$("#msg").val());
		$("#msg").val("")
	}
	function exit(){
        if(confirm("대화를 종료 하시겠습니까?")){
        	location.href="boardList"
        }
			
       
		
		
	}
	function del(){
		$("#msg").val("");
		$("#msg").focus();
	}
</script>
</head>
<body>
<div class="jumbotron text-center">
  <h2>관리자와의 채팅</h2>
</div>
<div class="container">
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">이름</span>
		</div>
		<input id="id" class="form-control"  placeholder="이름 입력"/>	
		<input type="button" class="btn btn-primary" value="입장" id="enterBtn"/>
		<input type="button" class="btn btn-danger" value="나가기" id="exitBtn" onclick="exit()"/>
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">대화 내용</span>
		</div>
		<div id="chatArea" style="overflow-x:hidden" class="input-group-append" >
			<div id="chatMessageArea"></div>
		</div>
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">전송 내용</span>
		</div>
		<input id="msg" class="form-control"  placeholder="전송할 메시지 입력"/>	
		<input type="button" class="btn btn-success" value="메시지 전송" id="sendBtn"/>
		<input type="button" class="btn btn-warning" value="메시지 삭제" id="delBtn" onclick="del()"/>
	</div>		    
</div>

</body>
</html>