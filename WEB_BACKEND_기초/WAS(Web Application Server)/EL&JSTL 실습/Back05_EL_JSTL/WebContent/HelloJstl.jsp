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
	
	<!-- jstl core를 배워보자 -->
	<c:out value="Hello World!"></c:out>		<!-- 양쪽 태그 사이에 쓸 내용이 있을때 -->
	<c:out value="Hello World!"/><br>			<!-- 태그 사이에 쓸 내용이 없을 때, 단일 태그 사용 가능 -->
	
	<!-- scope: 어디영역에다가 해당 변수를 선언할건지 
		 var  : 변수이름, 변수명 
		 value: 값
	-->
	<c:set var="msg" value ="hello1"/>
	${msg }
	
	<c:set var = "msg2">hello2</c:set><br>			<!--  value대신에 태그 사이에 값을 넣을 수 있다. -->
	${msg2 }
	
	
</body>
</html>