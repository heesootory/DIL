<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<h2>로그인하기</h2>
	<form action = "person" method = "post">
		<input type = "hidden" name ="action" value ="login">
		ID : <input type = "text" name = "id"><br>
		PW : <input type = "text" name = "pw"><br>
		<button>로그인</button>
	</form>


</body>
</html>