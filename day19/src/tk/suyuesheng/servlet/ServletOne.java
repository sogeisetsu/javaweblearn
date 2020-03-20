package tk.suyuesheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charSet=utf-8");
        response.setCharacterEncoding("utf-8");
        //实验读取文件
        //1.读取文件路径
        String realPath = request.getServletContext().getRealPath("/WEB-INF/敏感词汇.txt");
        System.out.println(realPath);
        File file = new File(realPath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
        String str = null;
        while ((str=bufferedReader.readLine())!=null){//除特殊标注外输出全是汉字
            System.out.println(str);
            System.out.println(new String(str.getBytes("utf-8"),"utf-8"));
            System.out.println(new String(str.getBytes("gbk"),"utf-8"));//???
            System.out.println(new String(str.getBytes("gbk")));//设置解码
            System.out.println(new String(str.getBytes("gbk"),"gbk"));
            response.addCookie(new Cookie("liu", str));
            response.getWriter().write(new String(str.getBytes("gbk")));
            response.getWriter().print("<br>");
            response.getWriter().print(str);
            response.getWriter().print("<br>");
            response.getWriter().write(str);
            response.getWriter().print("<br>");
            response.getWriter().write(new String("年后".getBytes("gbk")));
            response.getWriter().print("<br>");
            response.getWriter().write(new String("年后".getBytes("utf-8"),"utf-8"));
        }
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie :cookies){
            System.out.println(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
