<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="/Todo/css/register.css">
</head>
<body>
	<h1>할일 등록</h1>
	<form action="registerController" method="post">
	<div>
		어떤 일인가요?<p>
		<input type="text" name="title" placeholder="할일을 입력해주세요(24자까지)" required="required">
	</div>
	
	<div>
		누가 할 일인가요?<p>
		<input type="text" name="name" placeholder="할사람">
	</div>

	<div style="margin-bottom: 5%">
		우선순위를 선택하세요<p>
		<input type="radio" name="sequence" value="1">1순위
		<input type="radio" name="sequence" value="2">2순위
		<input type="radio" name="sequence" value="3">3순위
	</div>
	
	<div id = "work_list_btn_container">
		<input type="button" style="margin-right: auto; background-color: white;" value="< 이전" > 
		<input type="submit" style="margin-left: auto" value="제출">
		<input type="reset" style="margin-left: auto" value="다시작성">
	</div>
	</form>
</body>
</html>