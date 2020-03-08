<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/8
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证登录页面</title>
    <script>
        window.onload=function () {
            document.getElementById("img").onclick=function () {
                this.src="ServletImg?"+new Date().getTime();
            }
        }
    </script>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<%--<img src="login.jsp">--%>
<%
    out.println("hello");
%>
<form action="Servletlogin" method="get">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img src="ServletImg" id="img"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
    <div class="error"><%= request.getAttribute("checkCodeError")==null ? "":request.getAttribute("checkCodeError")%></div>
    <div class="error"><%= request.getAttribute("userError")==null ? "" : request.getAttribute("userError")%></div>
</form>
</body>
</html>
