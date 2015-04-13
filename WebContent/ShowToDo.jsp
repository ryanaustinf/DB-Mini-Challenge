<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mc.dto.ToDo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
	<style>
		html, body{
			height:100%;
			width:100%;
			margin:0px;
		}
		
		div, p{
			margin:0px;
			color:#1D1E1E;
			font-size:30px;
		}
		
		#add{
			float:left;
			height: 100%;
			width: 10%;
			background-color:#EB4B55;
		}
			
		.nav{
			background-color:#F4B6AC;
			width:100%;
			height:15%;
		}
		
		#up p, #down p{
			position:relative;
			top:45%;
			right:50%:
		}
		
		#content p{
			position:relative;
			top:45%;
			left:20%;
		}
		
		#add p{
			position:relative;
			top:45%;
			left:45%;
			color:#FFF7F3;
		}
		
		#content{
			background-color:#FFF7F3;
			width:100%;
			height:70%;
		}
	</style>
	<script src="jquery-2.1.1.js"></script>
	<script>
		<% ToDo toDo = (ToDo)request.getSession().getAttribute("todo");%>
		var id = <%=toDo.getToDoId()%>;
		$(document).ready(function(){
			if(id != -1){
				$("#hiddeninput").val(id);
				$("#up").click(function(){
					$("#hiddenform").attr("action","previous");
					$("#hiddenform").submit();
				});
				$("#down").click(function(){
					$("#hiddenform").attr("action","next");
					$("#hiddenform").submit();
				});
				$("#add").click(function(){
					window.location = "addnote.jsp";
				});
				$("#content").dblclick(function(){
					$("#hiddenform").attr("action","done").attr("method","POST");
					$("#hiddenform").submit();
				});
			}
		});
	</script>
</head>
<body>
	<div id="add">
		<p>+</p>
	</div>
	
	<div class="nav" id="up"></div>
	
	<div id="content">
		<p><%=toDo.getContent()%></p>
	</div>
	
	<div class="nav" id="down"></div>
	
	<form id="hiddenform">
		<input type="hidden" id="hiddeninput" name="id"/>
	</form>
</body>
</html>