package cn.suyuesheng.web.servlet;

import cn.suyuesheng.util.fectory.DomainFectory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDelSelect")
public class ServletDelSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //看是否登录
        Object userlogin = request.getSession().getAttribute("user");
        if(userlogin==null){
            //如果没有登录就转发
            request.setAttribute("loginError", "还没有登录,您没有相关权限");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        String[] uids = request.getParameterValues("uid");
//        for(String uid :uids){
//            System.out.println(uid);
//        }
        Boolean aBoolean=null;
        try {
            aBoolean = DomainFectory.getUserService().deleteByIds(uids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(aBoolean){
            //全部删除成功
            response.sendRedirect(request.getContextPath()+"/ServletFindUserByPage");
        }else{
            request.setAttribute("deleteSelectError", "出错，部分或全部未删除干净");
            request.getRequestDispatcher("/ServletIndex").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
