<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${person.no }<br>
	${person.name }<br>
	${person.age }<br>
	${person.msg }<br>
	
	<input type = "button" value = "수정" onClick = "location.href = 'person?action=updateForm&no=${person.no}'">
	<input type = "button" value = "삭제" onClick = "location.href = 'person?action=delete&no=${person.no}'">
	<input type = "button" value = "목록" onClick = "location.href = 'person?action=list'">
</body>
</html>