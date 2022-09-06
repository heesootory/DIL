<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Hello 출력  -->	
	<!-- EL  -->
	${"Hello"}<br>
	
	<!-- 표현식 -->
	<%= "Hello" %><br>
	
	<!-- 스크립트릿 -->
	<% out.print("Hello"); %><br>

</body>
</html>