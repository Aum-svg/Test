package a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/hello5","/hello6"})
@SuppressWarnings("serial")
public class AServlet extends HttpServlet{
	
	public AServlet() {
		System.out.println("创建aServlet对象");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		resp.getWriter().write("<h1>good afternoon</h1>");
	}
	
}
