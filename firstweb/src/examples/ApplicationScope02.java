package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApplicationScope02")
public class ApplicationScope02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplicationScope02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext app = getServletContext();
		try {
			int value = (int) app.getAttribute("value");	//object로 반환되기 때문에 형변환 해 줘야 함
			value++;
			app.setAttribute("value", value);

			out.println("<h1> value : "+ value +"</h1>");
		}catch (NullPointerException e) {
			out.print("value의 값이 설정되지 않았습니다");
		}
		
	}

}
