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
			<form action="TodoFormServlet" id="toServlet_form">
				<button type="submit" class="todoWriteBtn" form="toServlet_form">TO_DO 쓰러가기</button>
			</form>
		</div>
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
		<div class = "content_container">
			<c:forEach items="${ todoList }" var = "todoList">
				<div style="border: 1px solid;">
					제목 : ${ todoList.title }<br>
					작성자 : ${ todoList.name }
					<div class="frm_container">
						<form action="todoUpdateServlet" method="post" style="margin-left: auto;">
							<input type="hidden" name = "id" value="${ todoList.id }">
							<input type="hidden" name = "type" value="${ todoList.type }">
							<input type="submit" value="&gt;&gt;&gt;">
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div class = "content_container">
			<c:forEach items="${ doingList }" var = "doingList">
				<div style="border: 1px solid;">
					제목 : ${ doingList.title }<br>
					작성자 : ${ doingList.name }
					<div class="frm_container">
						<form action="todoReverseServlet" method="post">
							<input type="hidden" name = "id" value="${ doingList.id }">
							<input type="hidden" name = "type" value="${ doingList.type }">
							<input type="submit" value="&lt;&lt;&lt;">
						</form>
						<form action="todoUpdateServlet" method="post">
							<input type="hidden" name = "id" value="${ doingList.id }">
							<input type="hidden" name = "type" value="${ doingList.type }">
							<input type="submit" value="&gt;&gt;&gt;">
						</form>
					</div>
				</div>
			</c:forEach>	
		</div>
		
		<div class = "content_container" style="margin-right: 0;">
			<c:forEach items="${ doneList }" var = "doneList">
				<div style="border: 1px solid;">
					제목 : ${ doneList.title }<br>
					작성자 : ${ doneList.name }
					<div class="frm_container">
						<form action="todoReverseServlet" method="post">
							<input type="hidden" name = "id" value="${ doneList.id }">
							<input type="hidden" name = "type" value="${ doneList.type }">
							<input type="submit" value="&lt;&lt;&lt;">
						</form>					
						<form action="todoDeleteServlet" method="post">
							<input type="hidden" name = "id" value="${ doneList.id }">
							<input type="hidden" name = "type" value="${ doneList.type }">
							<input type="submit" value="XXX">
						</form>
					</div>
				</div>
			</c:forEach>		
		</div>
	</div>
<script type="text/javascript" src="javaScript/main.js"></script>
</body>
</html>