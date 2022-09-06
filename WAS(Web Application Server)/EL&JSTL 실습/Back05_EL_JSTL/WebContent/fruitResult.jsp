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
	
	<c:if test = "${param.fruit == 1}">
		<div style="color : red">킹스베리딸기</div>
	</c:if>
	<c:if test = "${param.fruit == 2}">
		<div style="color : pink">차돌복숭아</div>
	</c:if>
	<c:if test = "${param.fruit == 3}">
		<div style="color : green">샤인머스캣</div>
	</c:if>
	<c:if test = "${param.fruit == 4}">
		<div style="color : orange">애플망고</div>
	</c:if>
	
	<c:choose>
		<c:when test="${param.fruit == 1}">
			<div style="color : red">킹스베리딸기</div>
		</c:when>
		<c:when test="${param.fruit == 2}">
			<div style="color : pink">차돌복숭아</div>
		</c:when>
		<c:when test="${param.fruit == 3}">
			<div style="color : green">샤인머스캣</div>
		</c:when>
		<c:otherwise>
			<div style="color : orange">애플망고</div>
		</c:otherwise>
	</c:choose>

</body>
</html>