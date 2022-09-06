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
	
	<h2>오늘 나의 반찬은</h2>
	
	<hr>
	<c:forEach var="item" items="${paramValues.dish }" varStatus = "status">
		${item } <c:if test="${not status.last }">,</c:if>
	</c:forEach>


</body>
</html>