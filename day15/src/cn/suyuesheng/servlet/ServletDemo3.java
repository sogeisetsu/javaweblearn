package cn.suyuesheng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext=this.getServletContext();
        System.out.println(this);
        String fileName = "123.jpg";
        String mimeType = servletContext.getMimeType(fileName);//获取MIME类型
        System.out.println(mimeType);
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);//返回项目的真实路径
        servletContext.setAttribute("name", "张三");//域对象共享数据
        System.out.println((String) servletContext.getAttribute("name"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
