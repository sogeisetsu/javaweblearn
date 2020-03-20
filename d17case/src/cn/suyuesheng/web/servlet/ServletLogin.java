package cn.suyuesheng.web.servlet;

import cn.suyuesheng.domain.User;
import cn.suyuesheng.util.fectory.DomainFectory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取验证码
        String verifycode = request.getParameter("verifycode");
        Object checkCodee = request.getSession().getAttribute("checkCode");
        String checkCode= (String) checkCodee;
//        System.out.println("cc   "+checkCode);
        request.getSession().removeAttribute("checkCode");//验证码用一次作废
        //验证码是否正确
        if(checkCode!=null&&checkCode.equalsIgnoreCase(verifycode)){
            System.out.println("验证码输入正确");
        }else{
            request.setAttribute("loginError", "error  验证码错误");
            System.out.println("checkCodeError");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
//        System.out.println(request.getParameter("name"));
//        System.out.println(request.getParameter("password"));
        //获取账号密码
        Map<String, String[]> map = request.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user.getName()+"\t"+user.getPassword());
        Boolean login = null;
        try {
            login = DomainFectory.getUserService().login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(login){
            User login1=null;
            try {
                login1 = DomainFectory.getUserService().getLogin(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute("user", login1);
            Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
            cookie.setMaxAge(60*60*30);
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.setAttribute("loginError", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
