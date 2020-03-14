package cn.suyuesheng.web.servlet;

import cn.suyuesheng.domain.User;
import cn.suyuesheng.util.fectory.DomainFectory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/ServletAddUser")
public class ServletAddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        //看是否登录
        Object userlogin = request.getSession().getAttribute("user");
        if(userlogin==null){
            //如果没有登录就转发
            request.setAttribute("loginError", "还没有登录,您没有相关权限");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        User u = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(u,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(">-------------------");
//        System.out.println(u);
//        System.out.println(">--------------------");
        Boolean aBoolean=null;
        try {
            aBoolean = DomainFectory.getUserService().addUser(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(aBoolean){
            //如果添加成功的话
            response.sendRedirect(request.getContextPath()+"/ServletFindUserByPage");
        }else{
            //如果添加失败的话
            request.setAttribute("addError", "添加失败，请重新添加符合规则的数据");
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
