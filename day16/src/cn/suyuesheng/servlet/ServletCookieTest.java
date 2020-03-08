package cn.suyuesheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 检查Cookie是否合格
 * @author 苏月晟
 */
@WebServlet("/ServletCookieTest")
public class ServletCookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charSet=utf-8");
        Cookie[] cookies = request.getCookies();
        //查看是否登录过
        Boolean flag = false;//false说明从未登陆过
        if(cookies.length>0 && cookies!=null){
            for (Cookie e : cookies){
                if (e.getName().equals("lastTime")){
                    flag=true;
                    //设置cookie
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年-MM月-dd日 HH时mm分ss秒.S毫秒");
                    String s = dateFormat.format(date);
                    String ss =s;
                    ss = URLEncoder.encode(ss, "ISO-8859-1");
                    System.out.println("另一种"+ss);
                    System.out.println("编码前"+s);
                    s = URLEncoder.encode(s, "utf-8");
                    System.out.println("编码后"+s);
                    System.out.println(URLDecoder.decode(s,"ISO-8859-1"));
                    System.out.println();
                    String eValue1 = e.getValue();
                    eValue1=URLDecoder.decode(eValue1, "utf-8");
                    e.setValue(s);
                    e.setMaxAge(60*60*24*30);//cookie保存30天
                    response.addCookie(e);
                    //输出上次时间
                    String eValue = e.getValue();
                    PrintWriter writer = response.getWriter();
                    System.out.println("解码前"+eValue);
                    eValue = URLDecoder.decode(eValue, "utf-8");
                    System.out.println("解码后"+eValue);
                    writer.print("上次访问时间："+eValue1);
                    break;
                }
            }
        }
        if(cookies.length==0 || cookies==null || flag==false){
            //cookie特殊字符需要url编解码地操作
            Date dd = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            String s = simpleDateFormat.format(dd);
            System.out.println("编码前"+s);
            s = URLEncoder.encode(s, "utf-8");
            System.out.println("编码后"+s);
            Cookie cookieTime = new Cookie("lastTime", s);
            response.addCookie(cookieTime);
            PrintWriter writer = response.getWriter();
            s= URLDecoder.decode(s, "utf-8");
            System.out.println("解码后"+s);
            writer.print("<h1>第一次访问，访问时间是"+s+"</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
