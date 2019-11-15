package c;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session表示的是一次完整的会话<br>
 * 创建session是通过request<br>
 * 创建session有两种方式:<br>
 * 第一种: request.getSession(); 等价于 request.getSession(true); 表示, 如果有session就获取到, 如果没有session就创建出来<br>
 * 第二种: request.getSession(false); 表示, 如果有session就获取到, 如果没有session就获取不到
 */
@WebServlet("/session/a/session1")
@SuppressWarnings("serial")
public class TestSession extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		/**
		 * 获取到session对象
		 */
		HttpSession session =  req.getSession();
		
		/**
		 * 在session中存储值: setAttribute(String key, Object value);
		 */
		session.setAttribute("username", "siri");
		session.setAttribute("password", "siri123");
		
		resp.getWriter().write("这里是学习session使用的");
		
	}
	
	
}
