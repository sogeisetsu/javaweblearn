package cn.suyuesheng.web.servlet;

import cn.suyuesheng.util.fectory.DomainFectory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDeleteById")
public class ServletDeleteById extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //看是否登录
        Object userlogin = request.getSession().getAttribute("user");
        if(userlogin==null){
            //如果没有登录就转发
            request.setAttribute("loginError", "还没有登录,您没有相关权限");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        Boolean delete = false;
        try {
            delete = DomainFectory.getUserService().delete(Integer.parseInt(request.getParameter("id")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(delete){
            //如果删除成功
            response.sendRedirect(request.getContextPath()+"/ServletFindUserByPage");
        }else {
            //如果删除失败
            request.setAttribute("deleteError", "删除失败，请检查");
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
