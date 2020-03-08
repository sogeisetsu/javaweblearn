<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/3
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%
    System.out.println("hello world");
    //是第几次访问
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charSet=utf-8");
    boolean flag =false;
    //设置只要访问过就会有名为 last的cookie
    Cookie[] cookies = request.getCookies();
    if(cookies.length>0 && cookies!=null){
      for(Cookie c:cookies){
        if("last".equals(c.getName())){
          flag=true;
          Date date = new Date();
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒.S毫秒");
          String format = dateFormat.format(date);
          //编码
          format = URLEncoder.encode(format, "utf-8");
          String cValue = c.getValue();//上一次访问时间
          c.setValue(format);//设置新的时间
          c.setMaxAge(30*24*60*60);//设置cookie存活时间
          response.addCookie(c);
          //解码
          System.out.println("解码前 "+cValue);
          cValue = URLDecoder.decode(cValue, "utf-8");
          System.out.println("解码后 "+cValue);
          PrintWriter responseWriter = response.getWriter();
          responseWriter.print("<h2>您上一次的访问时间是"+cValue+"。谢谢</h2>");
          System.out.println("method---"+request.getMethod());
        }
      }
    }
    if(flag==false || cookies==null || cookies.length==0){//第一次访问的情况
      Date firstDate = new Date();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒.S毫秒");
      String format = dateFormat.format(firstDate);
      format = URLEncoder.encode(format, "utf-8");
      Cookie last = new Cookie("last", format);
      response.addCookie(last);
      PrintWriter responseWriter = response.getWriter();
      responseWriter.print("<h2>第一次访问呢，欢迎下次再来</h2>");
    }
  %>
<% out.print("建议输出到屏幕用out.print()");%>
<%
    ServletContext servletContext = request.getServletContext();
    out.print("<br>");
    out.print("项目路径"+servletContext.getRealPath("/")+"\n");
    HttpSession session1 = request.getSession();//服务器端共享数据
    out.print("<br>");
    Object msg = session1.getAttribute("msg");
    out.print("由Session对象获得："+(String)msg);
    Cookie[] cookies1 = request.getCookies();
    for(Cookie e:cookies){
        if("JSESSIONID".equals(e.getName())){
            out.print("<br>通过cookie对象获得"+e.getValue());
        }
    }
    out.println("<br>"+"JSESSIONID:   "+session1.getId());
    //让浏览器对应的session长期保存
    //不同的浏览器还是不一样
    Cookie cookie = new Cookie("JSESSIONID", session1.getId());
    cookie.setMaxAge(60*30);
    response.addCookie(cookie);
%>
<%--  <%= %>--%>
<br>
  <%= "直接输出"%>
  <%! //自定义类%>
  <br>

  </body>
</html>
