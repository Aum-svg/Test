package b;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie中存入中文会产生乱码的问题<br>
 * 这个问题在高版本上的服务器[tomcat8.5以后]已经不存在了, 可以直接存中文<br>
 * 
 * 解决低版本乱码问题的时候可以使用: URLEncoder 和 URLDecoder
 */
@WebServlet("/cookie/b/cookie2")
@SuppressWarnings("serial")
public class TestCookie2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String str = "在cookie中存入的中文信息";

		Cookie cookie = new Cookie("msg2", str);

		resp.addCookie(cookie);

		resp.getWriter().write("访问成功");

		/**
		 * 接收cookie
		 */
		Cookie[] cookies = req.getCookies();

		System.out.println("cookie个数: " + cookies.length);

		for (Cookie c : cookies) {

			if ("str".equals(c.getName())) {
				System.out.println(c.getName() + " -- " + c.getValue());

				System.out.println("cookie的信息为: " + c.getValue());
				System.out.println("马上修改cookie的信息.");

				/**
				 * 修改cookie有两种方式: <br>
				 * 第一种: 使用setValue()方法<br>
				 * 第二种: 创建同名cookie, 这样, 新值就会覆盖掉旧值
				 */
				c.setValue("使用setvalue方法对cookie的值进行修改");

				resp.addCookie(c);

			} else {
				System.out.println(c.getName() + " -- " + c.getValue());
			}

		}

	}

}
