<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  데이터 포맷팅을 해보자 -->
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		// get 방식이면 상관없는데 post방식이면 한글이 깨짐.
	%>
	
	<%= request.getParameter("name") %>
	
	<br><hr>
	
	<!-- formatting 방식 -->
	
	<fmt:requestEncoding value = "UTF-8"/>
	${param.name }

</body>
</html>