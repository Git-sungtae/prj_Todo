<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="../css/main.css">
</head>
<body>
	<div id="nav_container">
		<h2>나의 해야할 일들</h2>
		<div class="header">
			<form action="../TodoFormServlet" id="toServlet_form">
				<button type="submit" class="todoWriteBtn" form="toServlet_form">TO_DO 쓰러가기</button>
			</form>
		</div>
	</div>
	
	<div id = "content_nav">
		<div>
			TODO
		</div>
		<div>
			DOING
		</div>
		<div>
			DONE
		</div>
	</div>
	
	<div class = "content_container">
	
	</div>
	
	<div class = "content_container">
	
	</div>
	
	<div class = "content_container">
	
	</div>

<script type="text/javascript" src="../javaScript/main.js">

</script>
</body>
</html>