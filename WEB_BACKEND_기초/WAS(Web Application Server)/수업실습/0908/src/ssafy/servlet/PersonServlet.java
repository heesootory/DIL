package ssafy.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.person.dto.Person;
import com.ssafy.person.manager.PersonManager;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonManager pm = PersonManager.getInstance();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "login": doLogin(request, response); break;
		case "list" : doList(request, response); break;
		case "detail" : doDetail(request,response); break;
		case "updateForm" : doUpdateForm(request,response); break;
		case "update" : doUpdate(request,response); break;
		case "add" : doAdd(request,response); break;
		case "delete": dooDelete(request,response); break;
		}
	}
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		session.setAttribute("ss", "11");
		// 파라미터의 입력된 id와 pw 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		if(session.getAttribute("ss").equals(pw) && (id.equals("ss")) ) {
//			
//		}
		
		// id와 비번이 같을 때만 로그인.
		if(id.equals(pw)) {
			request.getSession().setAttribute("id", "heesoo");
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}
	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 사람목록을 attr 싣고,
		Person[] personList = pm.getAll();
		request.setAttribute("pList", personList);
		
		// list.jsp로 포워드
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//no파라미터를 받아서
		// 해당 사람을 personManager에서 조회해서 attr싣고
		//detail.jsp로 포워드
		int no = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("person", pm.getPerson(no));
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
	
	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//no파라미터를 받아서
		// 해당 사람을 personManager에서 조회해서 attr싣고
		//update.jsp로 포워드
		int no = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("person", pm.getPerson(no));
		request.getRequestDispatcher("update.jsp").forward(request, response);
	} 

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//일단 파라미터를 다 받고,
		// 그 정보들을 personManager에 update기능에 던지고.
		//해당 no 에 해당하는 detail요청으로 리다이렉트
		int no = Integer.parseInt(request.getParameter("no"));
		String name =  request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String msg = request.getParameter("msg");
		
		Person up_person = new Person(no, name, age, msg);
		pm.updatePerson(up_person);
		response.sendRedirect("person?action=detail&no="+no);
	}
	
	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 다 받고,
		//personManager에 add기능에 던지고
		// 해당 no에 detail로 리다이렉트
		int no = Integer.parseInt(request.getParameter("no"));
		String name =  request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String msg = request.getParameter("msg");
		
		Person new_person = new Person(no, name, age, msg);
		pm.addPerson(new_person);
		response.sendRedirect("person?action=detail&no="+no);
		
	}
	
	private void dooDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//no 파라미터를 받아서
		// 해당 사람 삭제 기능을 personManager의 delete에 던지고,
		// action=list로 리다이렉트
		
		int no = Integer.parseInt(request.getParameter("no"));
		pm.removePerson(no);
		response.sendRedirect("person?action=list");
	}
	

	
	
	
	
}
