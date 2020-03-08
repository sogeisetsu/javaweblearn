package cn.suyuesheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 探讨Cookie的共享
 * @author 苏月晟
 */
@WebServlet("/ServletCookieDemo3")
public class ServletCookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置对post方法的request的编码
        request.setCharacterEncoding("utf-8");
        //设置response的数据类型和编码格式
        response.setContentType("text/html;charSet=utf-8");
        //添加多个Cookie
        Cookie cookie1 = new Cookie("name", "su");
        Cookie cookie2 = new Cookie("sex", "man");
        cookie1.setPath("/");//设置Cookie的共享范围，此服务器下所有的web项目皆可访问
        cookie2.setPath("/day16");//设置Cookie的共享范围为/day16虚拟目录下的web项目
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
