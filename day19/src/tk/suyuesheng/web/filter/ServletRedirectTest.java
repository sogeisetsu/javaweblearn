package tk.suyuesheng.web.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 测试重定向会不会的DispatcherType=request来拦截
 */
@WebServlet("/ServletRedirectTest")
public class ServletRedirectTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        //重定向
        System.out.println("开始重定向------------");
        Boolean flag = true;//没有设置FilterMsg
        response.sendRedirect(request.getContextPath()+"/InterceptModeTest.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
