package com.ssafy.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

// 서블릿으로 업그레이드 시키고
// 쿠키를 한번 만들어 보기. -> 결국 서블릿임.

@WebServlet("/make")
public class MakeCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		
//		System.out.println(key);
//		System.out.println(value);
		
		// 쿠키를 생성
		Cookie cookie = new Cookie(key, value);
		
		// 유효시간(만료시간) -초단위
		cookie.setMaxAge(60);		// 1분
		
//		cookie.setMaxAge(0);         // 쿠키를 삭제할시.
		
		
		// 세션 정보를 request를 이용해서 담을 수 있다.
		HttpSession session = req.getSession();
		session.setAttribute("name", "hello");			// 추후에 공부할것임.
		
		
		
		resp.addCookie(cookie);			// 쿠키를 응답에 담아서
		resp.sendRedirect("cookie1.jsp");	// cookie1.jsp 로 보내준다.
		
	}
}
