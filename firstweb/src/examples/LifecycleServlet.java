package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* 
	 * WAS는 서블릿 요청을 받으면 해당 서블릿이 메모리에 있는지 확인
	 * if(메모리에 없음){
	 * 		해당 서블릿 클래스를 메모리에 올림(객체 생성)
	 * 		init()메소드 실행
	 * }
	 * service() 메소드 실행
	 * 
	 * WAS가 종료 되거나, 웹 어플리케이션이 새롭게 갱신 될 경우 destroy()메소드가 실행됨(서블릿 파괴)
	 * */
       
	// 처음에 요청된 객체가 메모리에 없음으로 최초에 한번 생성자 호출하여 객체 생성
    public LifecycleServlet() {
        System.out.println("LifecycleServlet 생성!!");
    }

	public void init(ServletConfig config) throws ServletException {
        System.out.println("init test 호출!!");
	}

	public void destroy() {
        System.out.println("destroy 호출!!");
	}

	// 브라우저 url에서 직접 넘어올 때는 get방식으로 요청이 넘어옴
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/firstweb/LifecycleServlet'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	// post 요청이 오면 호출됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

	/*
	 * service(request, response) 메소드
	 * 	HttpServlet의 service메소드는 템플릿 메소드 패턴으로 구현합니다.
	 *	 클라이언트의 요청이 GET일 경우에는 자신이 가지고 있는 doGet(request, response)메소드를 호출
	 *	 클라이언트의 요청이 Post일 경우에는 자신이 가지고 있는 doPost(request, response)를 호출
	 * */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("service 호출!!");
//	}
	
}
