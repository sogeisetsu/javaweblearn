<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/10
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl学习</title>
</head>
<%
    pageContext.setAttribute("number", 0);
    List<String> list = new ArrayList<String>();
    list.add("hello");
    list.add("world");
    list.add("你好");
    list.add("哈啊哈");
    pageContext.setAttribute("list", list);
%>
<body>
<h3>标签学习</h3>
<hr>
${number}
if标签
<c:if test="${number %2!=0 && number!=0}">
    <h4>${number}为奇数</h4>
</c:if>
<%--c:if 里面没有else--%>
<%--再写另外一种情况的c:if--%>
<c:if test="${number %2==0 && number!=0} ">
    <h4>${number}为偶数</h4>
</c:if>
<c:if test="${number ==0}">
    <h4>${number}这个数非奇非偶</h4>
</c:if>
<c:if test="true">
    hello<br>
</c:if>
i&nbsp;&nbsp;index&nbsp;&nbsp;count<br>
<c:forEach begin="1" end="10" step="1" var="i" varStatus="j">
    ${i}&nbsp;&nbsp;&nbsp;${j.index}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${j.count}<br>
</c:forEach>
<c:forEach items="${list}" var="i" varStatus="j">
    ${i}&nbsp;&nbsp;&nbsp;${j.index}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${j.count}<br>
</c:forEach>
</body>
</html>
