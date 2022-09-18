<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정하기</title>
</head>
<body>
	
	<h1> 사람 수정!</h1>
	<form action = "person" method = "post">
		<input type = "hidden" name = "action" value= "update">
		No : <input type = "text" name = "no" value = "${person.no }" readonly = "readonly"><br>
		이름 : <input type = "text" name = "name" value = "${person.name }"><br>
		나이 : <input type = "text" name = "age" value = "${person.age }"><br>
		소개 : <input type = "text" name = "msg" value = "${person.msg }"><br>
		<input type = "submit" value="수정">
	</form>

</body>
</html> 