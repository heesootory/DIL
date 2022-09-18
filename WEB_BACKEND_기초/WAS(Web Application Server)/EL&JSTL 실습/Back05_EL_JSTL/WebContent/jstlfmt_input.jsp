<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>POST 방식에서 한글 깨짐</h3>
	<form action = "jstlfmt_result.jsp"  method ="POST">
		<input type = "text" name = "name" placeholder ="이름을 입력하세요.">
		<button>제출</button>
	</form>

</body>
</html>