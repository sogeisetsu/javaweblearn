package suyuesheng.servlet;

import suyuesheng.query.Login;
import suyuesheng.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 将获取得信息实例化成User对象，并进行请求得跳转和资源的共享
 * @author 苏月晟
 */
@WebServlet("/query")
public class QueryRequest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String passWord = req.getParameter("password");
        try {
            if(Login.query(new User(name, passWord))==null){
                req.getRequestDispatcher("/false").forward(req, resp);
            }else {
                req.setAttribute("name", name);
                req.setAttribute("password", passWord);
                req.getRequestDispatcher("/true").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("post");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String passWord = req.getParameter("password");
        try {
            if(Login.query(new User(name, passWord))==null){
                req.getRequestDispatcher("/false").forward(req, resp);
            }else {
                req.setAttribute("login", new String[]{name,passWord});
                req.getRequestDispatcher("/true").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("get");
    }
}
