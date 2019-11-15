package b;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie的常用设置:<br>
 * 1, 删除cookie: 本质上是没有删除cookie一说的<br>
 * 可以通过设置cookie的存活时间来操作cookie
 * 
 * 2, cookie的路径问题: 默认是访问该路径下的cookie<br>
 * 
 * 3, 使用cookie的一些小问题:<br>
 * 	a, cookie是不安全的, 容易泄露隐私<br>
 *  b, 单个cookie的大小在4K以内<br>
 *  c, 单台服务器最多存储20个cookie<br>
 *  d, 一个浏览器中一般最多存300个左右的cookie<br>
 *  e, 在cookie中不能存储java的对象<br>
 *  
 *  4, 使用cookie最大的优点: 大大减轻了服务器的负担<br>
 *  在浏览器中可以长时间存储cookie
 *  
 */
@WebServlet("/cookie/c/cookie3")
@SuppressWarnings("serial")
public class TestCookie3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = new Cookie("cLife", "这是cookie的值");
		
		/**
		 *  这是设置cookie的最大存活时间, 单位是秒<br>
		 *  对于时间的设置有三种值:<br>
		 *  >0 表示cookie存活时间的秒数<br>
		 *  =0 表示删除cookie<br>
		 *  <= 表示浏览器会话结束时删除cookie, 要注意浏览器缓存问题<br>
		 */
		cookie.setMaxAge(-1);
		
		/**
		 * 设置cookie的路径<br>
		 * 可以用于一些网站的二级域名访问
		 */
		cookie.setPath("/");

		resp.addCookie(cookie);
		
		Cookie[] cookies = req.getCookies();
		System.out.println("cookie个数: " + cookies.length);
	}

}
