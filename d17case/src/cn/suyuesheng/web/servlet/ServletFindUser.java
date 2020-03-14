package cn.suyuesheng.web.servlet;

import cn.suyuesheng.domain.User;
import cn.suyuesheng.util.fectory.DomainFectory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletFindUser")
public class ServletFindUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //看是否登录
        Object userlogin = request.getSession().getAttribute("user");
        if(userlogin==null){
            //如果没有登录就转发
            request.setAttribute("loginError", "还没有登录,您没有相关权限");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        User user=null;
        try {
            user = DomainFectory.getUserService().findById(Integer.parseInt(request.getParameter("id")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user!=null){
            request.setAttribute("user", user);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }else{
            request.setAttribute("updateError", "没有查找到相关的用户，请刷新");
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
