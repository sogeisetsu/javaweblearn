package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据获取信息封装成user
        Map<String, String[]> map = request.getParameterMap();
        User u = new User();
        try {
            BeanUtils.populate(u, map);
        } catch (IllegalAccessException e) {


        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserServiceImpl userService = new UserServiceImpl();
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
