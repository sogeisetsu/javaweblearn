package cn.suyuesheng.session;

import club.suyuesheng.dbc.DatabaseConnection;
import club.suyuesheng.factory.ServiceFactory;
import club.suyuesheng.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/Servletlogin")
public class Servletlogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取发来的数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        String username = parameterMap.get("username")[0];
        String password = parameterMap.get("password")[0];
        String checkCode = parameterMap.get("checkCode")[0];
        User user = new User(username, password);
        System.out.println(DatabaseConnection.getTemplate());
        try {
            System.out.println(ServiceFactory.getUserServiceInstance(DatabaseConnection.getTemplate()).text(user) == null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(username+"\t"+password+"\t"+checkCode);
        String checkCode1 =(String)request.getSession().getAttribute("checkCode");
        request.getSession().removeAttribute("checkCode");//删除session，保证验证码使用一次就失效
        HttpSession session = request.getSession();
        if(checkCode1!=null && checkCode!=null && checkCode1.equalsIgnoreCase(checkCode)){
            //判断账户密码
            if("123".equals(user.getName())&&"123".equals(user.getPassWord())){
                //登录成功
                //储存用户信息
                request.getSession().setAttribute("user", user);
                //储存登录成功的消息
                Cookie cookie = new Cookie("login", "yes");
                response.addCookie(cookie);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                Cookie cookie = new Cookie("login", "no");
                response.addCookie(cookie);
                request.setAttribute("userError", "用户名或密码错误，请重试");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else{
            //验证码错误
            Cookie cookie = new Cookie("login", "no");
            response.addCookie(cookie);
            request.setAttribute("checkCodeError", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
