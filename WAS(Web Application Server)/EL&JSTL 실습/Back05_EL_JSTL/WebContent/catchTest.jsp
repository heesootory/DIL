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
	
	<c:catch var="errmsg">
		예외 발생 전<br>
	
		<!--  catch 처리를 해서 아래가 출력되지 않음. -->
		
		<%= 1/0 %>
		예외 발생 후<br>
	</c:catch>
	<c:out value="${errmsg }"/><br>
	${errmsg }

</body>
</html>