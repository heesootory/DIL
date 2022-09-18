<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 비교 연산 -->

${param.id }		<!-- 쿼리스트링으로 id값을 주어야 null이 아님. --> <!-- ?id=yang -->

== : 	<%= request.getParameter("id") == "yang" %><br>		<!-- false -->
equals() :  <%=request.getParameter("id").equals("yang") %><br> 		<!-- true -->


== : ${param.id == "yang"}		<!-- true: EL 표현법을 사용하면 == 표기를 해도 equals를 사용것처럼 내용물을 비교한다. -->



</body>
</html>