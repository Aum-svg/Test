package c;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 获取到session中的值, <br>
 * 删除session中的值
 */
@WebServlet("/session/a/session2")
@SuppressWarnings("serial")
public class TestSession2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		/**
		 * 获取到session对象
		 */
		HttpSession session =  req.getSession(false);
		
		/**
		 * 获取session的值: getAttribute(String key);
		 */
		Object username = session.getAttribute("username");
		
		
		resp.getWriter().write("获取session中的值: " + username);
		
		/**
		 * 删除掉session中的值: removeAttribute(String key)
		 */
		session.removeAttribute("password");
	}
	
	
}
