package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    /**
     * 用户注册
     * @param request
     * @param response
     * @throws IOException
     */
    public void regist(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //检测验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        System.out.println("registsession"+checkcode_server);
        System.out.println("regist_check"+request.getParameter("check"));
        session.removeAttribute("CHECKCODE_SERVER");

        if(checkcode_server==null|| !checkcode_server.equalsIgnoreCase(request.getParameter("check"))){
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(resultInfo);
            //编码
            response.setContentType("application/json;charset=utf-8");
            //发送
            response.getWriter().write(json);
            return;
        }
        //获取user对象
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //对象验证
        boolean regist = userService.regist(user);
        ResultInfo resultInfo = new ResultInfo();

        if(regist){
            resultInfo.setFlag(true);
        }else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败");
        }
        //发送信息
        //封装成json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(resultInfo);
        //编码
        response.setContentType("application/json;charset=utf-8");
        //发送
        response.getWriter().write(json);

    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws IOException
     */
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //根据获取信息封装成user
        Map<String, String[]> map = request.getParameterMap();
        User u = new User();
        try {
            BeanUtils.populate(u, map);
        } catch (IllegalAccessException e) {


        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //进行登录操作，数据库返回user
        User login = userService.login(u);
        ResultInfo resultInfo = new ResultInfo();
        if(login==null){
            //如果login为空
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或者密码错误");
        }else {
            if("y".equalsIgnoreCase(login.getStatus())){
                //如果user的status为y。说明用户已经激活
                resultInfo.setFlag(true);

                request.getSession().setAttribute("user", login);
            }else if ("n".equalsIgnoreCase(login.getStatus())){
                //如果n，说明用户还没有激活
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("未激活");
            }
        }
        //封装json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        //定义reponse的类型和编码
        response.setContentType("application/json;charset=utf-8");
        //将json写入输出流
        response.getWriter().write(json);
    }

    /**
     * 找到当前登录用户
     * @param request
     * @param response
     * @throws IOException
     */
    public void findeOne(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        //将user写回客户端

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),user);
    }

    /**
     * 用户退出
     * @param request
     * @param response
     * @throws IOException
     */
    public void exit(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //1.销毁session
        request.getSession().invalidate();

        //2.跳转登录页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 用户激活
     * @param request
     * @param response
     * @throws IOException
     */
    public void activeUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //获取激活码
        String code = request.getParameter("code");
        if(code!=null||code==""){//code不为空
            //进行激活
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
}
