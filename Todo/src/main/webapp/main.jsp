<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="css/main.css">
</head>
<body>
	<div id="nav_container">
		<h2>나의 해야할 일들</h2>
		<div class="header">
			<form  action="register.jsp" id="addTodoController">
				<button type="submit" class="todoWriteBtn" form="addTodoController">TO_DO 쓰러가기</button>
			</form>
		</div>
	</div>
	<div class = "get_btn">
			<form action="main">
			<input type="submit" value="저장된 할일 가져오기">
			</form>
	</div>
	<div id = "content_nav">
		<div>
			TODO<p>
			
		</div>
		<div>
			DOING
		</div>
		<div>
			DONE
		</div>
	</div>

	
	<div class = "outer_content_container">
	
		
		<div class = "content_container" id = "asdasd">
			<div id = TODO>
			</div>
		</div>
		
		<div class = "content_container">
			<div id = DOING>
			</div>
		</div>
		
		<div class = "content_container" style="margin-right: 0;">
			<div id = DONE>
			</div>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src = "./js/main.js"></script>
</body>
</html>		
	<%-- 		<c:forEach items="${ todoList }" var = "todoList">
				<div style="border: 1px solid;" >
					제목 : ${ todoList.title }<br>
					작성자 : ${ todoList.name }
					<div class="frm_container">
						<form action="todoUpdateServlet" method="post" style="margin-left: auto;">
							<input type="hidden" name = "id" value="${ todoList.id }">
							<input type="hidden" name = "type" value="${ todoList.type }">
							<input type="submit" value="&gt;&gt;&gt;" class="data${todoList.id}" onclick="move(this)">
						</form>
						<div>
							<input type="hidden" name = "id" value="${ todoList.id }">
							<input type="hidden" name = "type" value="${ todoList.type }">
							<input type="submit" value="&gt;&gt;&gt;" class="data${todoList.id}" onclick="move(this)">
						</div>
					</div> 
				</div>
			</c:forEach>--%>
	
		

<%-- 			<c:forEach items="${ doingList }" var = "doingList">
				<div style="border: 1px solid;" id="data${doingList.id}">
					제목 : ${ doingList.title }<br>
					작성자 : ${ doingList.name }
					<div class="frm_container"> --%>
						<%--<form action="todoReverseServlet" method="post">
							<input type="hidden" name = "id" value="${ doingList.id }">
							<input type="hidden" name = "type" value="${ doingList.type }">
							<input type="submit" value="<<<">
						</form> --%>
<%-- 						<form action="main" method="post">
							<input type="hidden" name = "id" value="${ doingList.id }">
							<input type="hidden" name = "type" value="${ doingList.type }">
							<input type="hidden" name = "lgBtn" value=-1>
							<input type="submit" value="<<<" class="data${doingList.id}" onclick="move(this)">
						</form> --%>
						
						<%-- <form action="todoUpdateServlet" method="post">
							<input type="hidden" name = "id" value="${ doingList.id }">
							<input type="hidden" name = "type" value="${ doingList.type }">
							<input type="submit" value=">>>">
						</form> --%>
<%-- 						<form action="main" method="post">
							<c:set var="id" value="${ doingList.id }" scope="request" />
							<c:set var="type" value="${ doingList.type }" scope="request" />
							<c:set var="lrBtn" value="right" scope="request" />
							<input type="submit" value=">>>" class="data${doingList.id}" onclick="move(this)">
						</form>
					</div>
				</div>
			</c:forEach>	
		
		
		
			<c:forEach items="${ doneList }" var = "doneList">
				<div style="border: 1px solid;" id="data${doneList.id}">
					제목 : ${ doneList.title }<br>
					작성자 : ${ doneList.name }
					<div class="frm_container">
						<form action="todoReverseServlet" method="post">
							<input type="hidden" name = "id" value="${ doneList.id }">
							<input type="hidden" name = "type" value="${ doneList.type }">
							<input type="submit" value="&lt;&lt;&lt;" class="data${doneList.id}" onclick="move(this)">
						</form>					
						<form action="todoDeleteServlet" method="post">
							<input type="hidden" name = "id" value="${ doneList.id }">
							<input type="hidden" name = "type" value="${ doneList.type }">
							<input type="submit" value="XXX" class="data${doneList.id}" onclick="move(this)">
						</form>
					</div>
				</div>
			</c:forEach>		
		</div> --%>
