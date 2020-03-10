<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/9
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="error.jsp" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
//    int c = 12/0;
//    out.print(c);
    HttpSession session1 = request.getSession();
    session1.setAttribute("session1", "hha");
    ServletContext servletContext = request.getServletContext();
    servletContext.setAttribute("servletContext", "jj");

  %>
  <a href="el/elOne.jsp" target="_self">el/elOne.jsp</a>
  <a href="jstl/jstlOne.jsp" target="_self">jstl/jstlOne.jsp</a>
  $END$
  </body>
</html>
