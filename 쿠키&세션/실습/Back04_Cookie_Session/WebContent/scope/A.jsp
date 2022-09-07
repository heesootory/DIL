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
		// 서블릿의 활동범위에 해당하는 각각의 영역에 저장.
		pageContext.setAttribute("name", "page yang");
		request.setAttribute("name", "request yang");
		session.setAttribute("name", "session yang");
		application.setAttribute("name", "application yang");
		
		System.out.println("A.jsp");
		System.out.println("페이지 속성 " + pageContext.getAttribute("name"));
		System.out.println("요청 속성 "+ request.getAttribute("name"));
		System.out.println("세션 속성 "+ session.getAttribute("name"));
		System.out.println("어플리케이션 속성 "+ application.getAttribute("name"));
		
		request.getRequestDispatcher("B.jsp").forward(request, response);
		
	%>
	
	
</body>
</html>