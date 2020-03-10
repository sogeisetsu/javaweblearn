<%@ page import="java.math.BigDecimal" %>
<%@ page import="cn.suyuesheng.day17.text.TestOne" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/9
  Time: 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="/error.jsp"  %>
<%--<%@taglib prefix="c" uri="" %>--%>
<%--<%@ taglib prefix="c"  %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>--%>

<html>
<head>
    <title>el尝试</title>
</head>
<body>
<%
    out.print(3/4);
    out.print("<br>");
    out.print(3%4);
    out.print("<br>");
    double div = TestOne.div((double) 3 / 4, 1);
    out.print(div);
//    out.print(1/0);
    request.setAttribute("name", "san");
    request.setAttribute("request", request.getServletContext());
    System.out.println((String) request.getAttribute("name"));
    pageContext.setAttribute("pageContextt", "kl from pageContext");
    request.setAttribute("pageContextt","lk from request");
    List<String> list = new ArrayList<String>();
    list.add("hello");
    list.add("world");
    request.setAttribute("list", list);
    Map<String,Integer> map = new HashMap<String, Integer>();
    map.put("一", 1);
    map.put("二", 2);
    request.setAttribute("map", map);
%>
<hr>
<p>\${12>15}的结果是：${12>15}</p>
<h3>算数运算</h3>
<hr>
\${1 div 2}== ${1 div 2} <br>
\${1 mod 2}== ${1 mod 2} <br>
\${1 / 2} == ${1/2}<br>
\${1 % 2} == ${1%2}<br>
\${1+2==3 && 1+1==2} == ${1+2==3 && 1+1==2}<br>
\${empty ""} == ${empty ""}<br>
\${empty requestScope.list} == ${empty requestScope.list}<br>
<h3>获取值</h3>
<hr>
\${requestScope.name} == ${requestScope.name}&nbsp;&nbsp;&nbsp;\\注意 此请求是在当前页面添加的<br>
\${pageScope.pageContext} == ${pageScope.pageContextt}&nbsp;&nbsp;\\作用域为当前页面<br>
\${sessionScope.session1} == ${sessionScope.session1}<br>
\${applicationScope.servletContext} == ${applicationScope.servletContext}<br>
\${pageContextt} == ${pageContextt}&nbsp;&nbsp;//从最小的域开始查询<br>
<h3>获取对象</h3>
<hr>
\${requestScope.request.getRealPath("")} == ${requestScope.request.getRealPath("")}&nbsp;&nbsp;\\注意该建对应的是request.getServletContext()<br>
\${requestScope.list[1]} == ${requestScope.list[1]}&nbsp;&nbsp;\\该建对应的是一个List<br>
\${requestScope.map.一} == ${requestScope.map.一}<br>
\${requestScope.map["二"]} == ${requestScope.map["二"]}&nbsp;<br>
<h3>获得隐式对象</h3>
<hr>
\${pageContext.request.contextPath} == ${pageContext.request.contextPath}<br>
\${pageContext.request.requestURI} == ${pageContext.request.requestURI} <br>
<hr>
${1/0}

</body>
</html>
