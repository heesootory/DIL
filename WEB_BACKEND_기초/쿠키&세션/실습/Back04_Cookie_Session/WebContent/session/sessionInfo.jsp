<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 정보를 얻어와 보자.</h2>
	<%
		String sessionId = session.getId();
		long lastTime = session.getLastAccessedTime();
		long createTime = session.getCreationTime();
		
		int inactive = session.getMaxInactiveInterval() / 60;  //세션의 유효기간 - 따로 설정을 안하면 기본값은 30분.
		
		long useTime = (lastTime-createTime) / 60000;
	%>
	<p>세션 아이디는
		<%=sessionId %>
	</p>
	<p>머문 시간은
		<%=useTime %>
	</p>
	<p>유효 시간은
		<%=inactive %>
	</p>
</body>
</html>