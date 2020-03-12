package cn.suyuesheng.web.servlet;

import cn.suyuesheng.domain.User;
import cn.suyuesheng.util.fectory.DomainFectory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charSet=utf-8");
        List<User> all= null;
        try {
            all = DomainFectory.getUserService().findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list", all);
        System.out.println(all);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
