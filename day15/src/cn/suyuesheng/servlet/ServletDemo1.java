package cn.suyuesheng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("正常---post");
        System.out.println(request.getRequestURL().toString());
        System.out.println(request.getContextPath());
        System.out.println("重定向");
//        resp.setStatus(302);
//        resp.setHeader("location","ServletDemo2");
        //第二种方法重定向
        //虚拟目录用req.getContextPath()来表示
        response.sendRedirect(request.getContextPath()+"/ServletDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(resp.getCharacterEncoding());
        resp.setCharacterEncoding("utf-8");
        ServletOutputStream servletOutputStream=resp.getOutputStream();
        servletOutputStream.print("hahahaha");
        servletOutputStream.write("你号".getBytes("utf-8"));
        ServletContext context = this.getServletContext();
        Object name = context.getAttribute("name");
        System.out.println((String) name);

    }
}
