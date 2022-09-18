<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사람들 목록 페이지</title>
</head>
<body>
<h1>사람 목록</h1>

<table>
	<tr>
		<th>NO</th>
		<th>이름</th>
	</tr>
	<c:forEach var="p" items= "${pList }">
		<tr>
			<td>${p.no}</td>
			<td><a href = "person?action=detail&no=${p.no }">${p.name}</a></td>
		</tr>
	</c:forEach>
	
</table>
<input  type = "button" value = "사람추가" onclick = "location.href ='add.jsp'">	
	
	
</body>
</html>