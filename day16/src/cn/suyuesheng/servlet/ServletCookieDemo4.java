package cn.suyuesheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接收demo3的cookie
 * @author 苏月晟
 */
@WebServlet("/ServletCookieDemo4")
public class ServletCookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charSet=utf-8");
        System.out.println("/day16/ServletCookieDemo4 ----------------------------");
        Cookie[] cookies = request.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("name") || c.getName().equals("sex")){
                System.out.println(c.getName()+"\t"+c.getValue());
            }
        }

        System.out.println("end ----------------------------------------------------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
