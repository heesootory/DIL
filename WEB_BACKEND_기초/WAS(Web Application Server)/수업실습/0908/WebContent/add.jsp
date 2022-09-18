<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 사람 추가!</h1>
	<form action = "person" method = "post">
		<input type = "hidden" name = "action" value= "add">
		No : <input type = "text" name = "no"><br>
		이름 : <input type = "text" name = "name"><br>
		나이 : <input type = "text" name = "age"><br>
		소개 : <input type = "text" name = "msg"><br>
		<input type = "submit" value="추가추가">
	</form>

</body>
</html>