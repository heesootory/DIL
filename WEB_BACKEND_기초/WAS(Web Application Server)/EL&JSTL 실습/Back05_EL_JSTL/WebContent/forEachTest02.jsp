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
	
	<table border = "1" text-align="center" >
		<tr>
			<th>index</th>
			<th>count</th>
			<th>title</th>
		</tr>
		<c:forEach var = "movie" items ="${movieList }" varStatus="status" begin="0" end="5" step="1">
			<tr>
				<td>${status.index }</td>
				<td>${status.count }</td>
				<td>${movie }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>