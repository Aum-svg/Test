package a;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet中并发安全性问题<br>
 * 在servlet中使用成员变量可能会产生线程并发安全问题,<br>
 * 解决方案: 不允许在servlet中创建成员变量. 把我们需要的变量写成局部变量<br>
 * 
 * 备用方案: [不建议使用] 让servlet实现SingleThreadModel, 这是一个过时的接口<br>
 * 
 * 跟servlet直接关系的是struts2 和 springMVC这两个框架.<br>
 * struts2框架是线程安全的<br>
 * springMVC是线程不安全的<br>
 */
@WebServlet("/ss")
@SuppressWarnings("serial")
public class SServlet extends HttpServlet implements SingleThreadModel{

	// 这两个是成员变量
	// int num1;
	// int num2;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num1;
		int num2;
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 接收前端传递的参数
		num1 = Integer.parseInt(req.getParameter("num1"));
		num2 = Integer.parseInt(req.getParameter("num2"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int sum = num1 + num2;
		
		resp.getWriter().write("sum: " + sum);
		
	}
	
}
