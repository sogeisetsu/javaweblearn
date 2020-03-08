package suyuesheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/true")
public class TureDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("》-------------------------------");
        System.out.println("登录成功");
        System.out.println("name>---"+(String) req.getAttribute("name"));
        System.out.println("password>---"+(String) req.getAttribute("password"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("》-------------------------------");
        System.out.println("登录成功");
        System.out.println("name>---"+(String) req.getAttribute("name"));
        System.out.println("password>---"+(String) req.getAttribute("password"));
    }
}
