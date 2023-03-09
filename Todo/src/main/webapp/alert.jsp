<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>alert</h1>
<script type="text/javascript" >

 	/* var string = "${ string }"; */
 	var string = '<c:out value = "${ string }" />' ;
 	/* var url = "${ url }"; */
 	var url = '<c:out value = "${ url }" />';
	
	alert(string);
	location.href = url;
</script>
</body>
</html>