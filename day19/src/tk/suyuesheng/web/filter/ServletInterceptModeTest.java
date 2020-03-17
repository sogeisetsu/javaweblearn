package tk.suyuesheng.web.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/ServletInterceptModeTest")
public class ServletInterceptModeTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("转发进入");
        request.setCharacterEncoding("utf-8");
        request.setAttribute("转发实验", "转发进入");
        Boolean flag = true;//没有设置FilterMsg
        request.getRequestDispatcher("InterceptModeTest.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
