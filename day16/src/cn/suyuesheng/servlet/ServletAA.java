package cn.suyuesheng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletAA")
public class ServletAA extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charSet=utf-8");
        //获取输出流
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<h1>hello world</h1>");
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("");//D:\day13\out\artifacts\day16_war_exploded\   返回的其实就是该项目tomcat配置web项目的dataBase
        System.out.println(realPath);
        System.out.println(context.getRealPath("/"));//D:\day13\out\artifacts\day16_war_exploded\
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
