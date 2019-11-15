package b;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 学习cookie, 它相当于是我们生活中 不记名, 不挂失的会员卡<br>
 * 由客户端来保管<br>
 * 只要cookie存在, 每次都会被带在请求中<br>
 */
@WebServlet("/cookie/a/cookie1")
@SuppressWarnings("serial")
public class TestCookie extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取从前端发送过来的数据
		String username = req.getParameter("username");
		
		/**
		 * 创建cookie, 并且把数据存入到cookie中, 存储方式是key--value<br>
		 */
		Cookie cookie = new Cookie("username", username);
		
		// 把创建好的cookie发送给客户端
		// 重点注意: 是发送给客户端, 只能够在响应中发送
		resp.addCookie(cookie);
		
		resp.getWriter().write("恭喜您, 登录成功");
		
		/**
		 * 获取请求中携带的cookie<br>
		 * 因为在一个网站中可以有多个cookie, 所以, 在请求中的cookie是一个数组
		 */
		Cookie[] cookies = req.getCookies();
		
		username = null;
		
		if(cookies != null) {
			
			for (Cookie c : cookies) {
				// 获取到cookie的名字
				String cname = c.getName();
				
				if("username".equals(cname)) {
					username = c.getValue();
				}
			}
			
		} else {
			System.out.println("没有cookie");
		}
		
		resp.getWriter().write("欢迎 " + username + " 再次登录, 上次登录时间为:");
		
	}

}
