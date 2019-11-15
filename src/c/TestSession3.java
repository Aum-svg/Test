package c;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session中存储对象<br>
 * 
 * session的生命周期: 一次完整的会话结束<br>
 * 服务器中默认的时长为30min, 从客户不做任何操作开始倒计时<br>
 * setMaxInactiveInterval(60); 设置sessio的存活时长为60min<br>
 * 还可以在web.xml文件中配置session的存活时长 使用session-config标签中的session-timeout标签
 * 
 */
@WebServlet("/session/a/session3")
@SuppressWarnings("serial")
public class TestSession3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 创建出实体对象
		User user = new User(1, "lucy", "lucy123");
		
		/**
		 * 获取到session对象
		 */
		HttpSession session =  req.getSession();
		
		/**
		 * 设置session的存活时长, 单位是min
		 */
		session.setMaxInactiveInterval(60);
		
		/**
		 * 存储user对象到session中
		 */
		session.setAttribute("user", user);
		
		/**
		 * 获取session中的值
		 */
		User u = (User) session.getAttribute("user");
		
		resp.getWriter().write(u.toString());
	} 
	
	
	
}
