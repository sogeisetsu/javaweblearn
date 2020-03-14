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

@WebServlet("/ServletUpdateUser")
public class ServletUpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //看是否登录
        Object userlogin = request.getSession().getAttribute("user");
        if(userlogin==null){
            //如果没有登录就转发
            request.setAttribute("loginError", "还没有登录,您没有相关权限");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        System.out.println(map);
        try {
            BeanUtils.populate(user,map);
//            System.out.println(">--------------------");
//            System.out.println(user);
//            System.out.println(">--------------------");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(">--------------------");
//        System.out.println(user);
//        System.out.println(">--------------------");
        try {
            Boolean update = DomainFectory.getUserService().update(user);
            if(update){
                response.sendRedirect(request.getContextPath()+"/ServletFindUserByPage");
            }else {
                request.setAttribute("updateError", "更新用户操作失败请刷新");
                request.getRequestDispatcher("/update.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("updateError", "出现未知错误请刷新");
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
