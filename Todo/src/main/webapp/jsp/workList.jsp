<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="../css/workList.css">
</head>
<body>
	<h1>할일 등록</h1>
	<form action="../TodoAddServlet" method="post">
	<div>
		어떤 일인가요?<p>
		<input type="text" name="work_name" placeholder="swift 공부하기(24자까지)" required="required">
	</div>
	
	<div>
		누가 할 일인가요?<p>
		<input type="text" name="work_who" placeholder="홍길동">
	</div>

	<div style="margin-bottom: 5%">
		우선순위를 선택하세요<p>
		<input type="radio" name="work_priority" value="1순위">1순위
		<input type="radio" name="work_priority" value="2순위">2순위
		<input type="radio" name="work_priority" value="3순위">3순위
	</div>
	
	<div id = "work_list_btn_container">
		<input type="button" style="margin-right: auto; background-color: white;" value="< 이전"> 
		<input type="submit" style="margin-left: auto" value="제출">
		<input type="reset" style="margin-left: auto" value="다시작성">
	</div>
	</form>
	
	
	
	
	
</body>
</html>