package cn.suyuesheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CookieDemo 体验Cookie在客户端的数据共享，此Demo负责创建并发送Cookie
 * @author 苏月晟
 */
@WebServlet("/ServletCookieDemoOne")
public class ServletCookieDemoOne extends HttpServlet {
    /**
     * 对method 为 Post 的处理办法
     * @param request 请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie cookie = new Cookie("msg", "你好");
        //response响应Cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
