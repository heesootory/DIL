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
	<%
		String[] movieList = {"육사오", "탑건", "인터스텔라", "외계인", "공조2"};
	
		pageContext.setAttribute("movieList", movieList);
		
	%>
	
	
	<c:forEach var="movie" items="${movieList }">
		${movie } <br>
	</c:forEach>

</body>
</html>