<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	request.setAttribute("name", "request yang");
	session.setAttribute("name", "request yang");
	application.setAttribute("name", "request yang");
	
%>


name : ${name}<br>
<%= pageContext.getAttribute("name") %><br>		<!-- null -->
page 속성  : ${pageScope.name}<br>
request 속성 : ${requestScope.name}<br>
session 속성 : ${sessionScope.name}<br>
application 속성 : ${application.name}<br>

</body>
</html>