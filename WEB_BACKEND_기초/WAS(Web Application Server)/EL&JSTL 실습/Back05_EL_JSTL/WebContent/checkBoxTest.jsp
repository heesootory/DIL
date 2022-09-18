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
	
	<h2>반찬를 골라보자.</h2>
	
	<form action="checkBoxResult.jsp">
		<input type = "checkBox" name = "dish" value ="김치전"> 김치전
		<input type = "checkBox" name = "dish" value ="계란말이"> 계란말이
		<input type = "checkBox" name = "dish" value ="연근조림"> 연근조림 <br>
		<input type = "checkBox" name = "dish" value ="제육볶음"> 제육볶음
		<input type = "checkBox" name = "dish" value ="소세지야채볶음"> 쏘야
		<input type = "checkBox" name = "dish" value ="삼겹살"> 삼겹살 <br>
		<input type = "submit" value = "구매">
	</form>
	

</body>
</html>