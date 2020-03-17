<%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/15
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  ${pageContext.request.contextPath}
  ${pageContext.request.servletContext.getRealPath("")}
  <h1>欢迎您</h1>
  <%
    out.print("hello");
  %>

  </body>
</html>
