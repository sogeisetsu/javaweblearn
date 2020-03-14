package cn.suyuesheng.web.servlet;

import cn.suyuesheng.domain.User;
import cn.suyuesheng.util.BeanPage;
import cn.suyuesheng.util.fectory.DomainFectory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/ServletFindUserByPage")
public class ServletFindUserByPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        //看是否登录
        Object userlogin = request.getSession().getAttribute("user");
        if(userlogin==null){
            //如果没有登录就转发
            request.setAttribute("loginError", "还没有登录,您没有相关权限");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        request.setAttribute("address", request.getParameter("address"));
        request.setAttribute("email", request.getParameter("email"));
        Map<String, String[]> map = request.getParameterMap();
        if(currentPage==null || "".equals(currentPage) ){
            currentPage="1";
        }
        if(rows==null || "".equals(rows)){
            rows="5";
        }
        try {
            BeanPage<User> userByPage = DomainFectory.getUserService().findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows), map);
            request.setAttribute("BeanPage", userByPage);
            System.out.println(userByPage);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
