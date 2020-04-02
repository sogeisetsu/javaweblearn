package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取激活码
        String code = request.getParameter("code");
        if(code!=null||code==""){//code不为空
            //进行激活
            UserServiceImpl userService = new UserServiceImpl();
            boolean active = userService.active(code);
            if(active){
                String msg= "<p>注册成功，请去登录，<a href=\""+"http://localhost/travel/login.html\""+">登录</a><p>";
                response.getWriter().write(msg);
            }else{
                String msg = "<p>登陆失败，请联系管理员</p>";
                response.getWriter().write(msg);
            }
        }else {
            String msg= "<p>未检测到注册码存在，请重新注册</p>";
            response.getWriter().write(msg);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
