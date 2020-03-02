package cn.suyuesheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());
        //设置字符流编码格式
//        response.setCharacterEncoding("utf-8");//这一行可以不写
        //设置浏览器解码格式
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Type","text/html;charset=utf-8");
        PrintWriter printWriter =response.getWriter();
        printWriter.print("<h1>response输出数据</h1>");
        printWriter.print("输出字节数据");
        printWriter.print("dd");
        ServletOutputStream servletOutputStream=response.getOutputStream();
        servletOutputStream.write("hello".getBytes("utf-8"));
//        PrintStream printStream = new PrintStream(servletOutputStream);
//        printStream.print("<h1>字节数据byte</h1>");
    }
}
