package cn.suyuesheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletCookieDemoTwo")
public class ServletCookieDemoTwo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charSet=utf-8");
        System.out.println(">----------------------通过getCookies来获取Cookie");
        Cookie[] cookies = request.getCookies();
        System.out.println("cookie的长度"+cookies.length);
        for(Cookie c : cookies){
            String cName = c.getName();
            String cValue = c.getValue();
            System.out.println("Name:"+cName+"\t"+"value:"+cValue);
            System.out.println("Cookie对象:\t"+c);
        }
        System.out.println(">----------------------通过header来获取cookie");
        String cookieFromHeader = request.getHeader("Cookie");
        //get方式获取头数据，先解码ISO-8859-1  再编码utf-8
        cookieFromHeader = new String(cookieFromHeader.getBytes("ISO-8859-1"),"utf-8");
        System.out.println(cookieFromHeader);
        System.out.println(">----------------------------------------");
        String[] strings = cookieFromHeader.split(";");
        for(String a:strings){
            String[] strings1 = a.split("=");
            System.out.println(strings1[0]+"\t==\t"+strings1[1]);
//            System.out.println(a);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
