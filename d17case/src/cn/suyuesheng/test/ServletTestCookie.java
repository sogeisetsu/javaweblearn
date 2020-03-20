package cn.suyuesheng.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/ServletTestCookie")
public class ServletTestCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charSet=utf-8");
        Cookie cookie1 = new Cookie("one", "one");
        cookie1.setMaxAge(-1);
        String ll ="ll ll ";
        String encode = URLEncoder.encode(ll, "utf-8");
        Cookie cookie = new Cookie("cj", encode);
        cookie.setMaxAge(60*60*30);
        response.addCookie(cookie);
        response.addCookie(cookie1);
        Cookie[] cookies = request.getCookies();
        for(Cookie c:cookies){
            if (c.getName().equals("cj")) {
                System.out.println(c.getValue());
                System.out.println(URLDecoder.decode(c.getValue(), "utf-8"));
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
