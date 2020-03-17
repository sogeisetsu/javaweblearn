<%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/16
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${cookie.FilterMsg.value}
<h1>正常进入</h1>
<a href="ServletInterceptModeTest">尝试转发进入</a>
<br>
<p>是否是转发进入</p>${pageContext.request.getAttribute("转发实验")}
<br>
<a href="ServletRedirectTest">尝试重定向进入</a>
<br>
<a href="user/ServletFilterTest">查看过滤器拦截路径为/* 时 访问/user/ServletFilterTest会被拦截几次?答案是一次</a>
</body>
</html>
