<%@ page import="User" %><%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/8
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
    <style>
        #title{
            color: red;
        }
        .error{
            color: red;
        }
    </style>
    <script>
<%--        跳转--%>
        window.onload=function () {
            function getcookie(cname) {
                var cookie = document.cookie;
                var strings = cookie.split(";");
                for(var i =0 ; i<strings.length ; i++){
                    var string=cname+"=";
                    if(strings[i].trim().indexOf(string)==0){
                        return strings[i].trim().substring(string.length,strings[i].trim().length);
                    }
                }
                return "";
            }
            console.log(getcookie("login"))
            if(getcookie("login")=="no"){
                alert("还没有登录，即将跳转");
                console.log(getcookie("login"))
                window.setTimeout(console.log("休眠"),2000);
                window.open("http://localhost/day16/login.jsp");
            }
        }
    </script>
</head>
<body>
<%
    //判断是否已经登录成功，登录成功再查询，防止出错
    Cookie[] cookies = request.getCookies();
    int flag = -1;
    for(Cookie c : cookies){
        if("login".equals(c.getName())){
            if ("yes".equals(c.getValue())){
                out.println("登录成功");
                flag=1;
                out.print("<h1 id=title>"+"欢迎您"+((User)request.getSession().getAttribute("user")).getName()+"</h1>");
                break;
            }else{
                out.println("<h3 class=error id=ee>登录失败</h3>");
                flag=0;
            }
        }
    }
    if(flag== -1){
        out.println("<h2 class=error>未查询到您曾经输入过关于账号密码的信息，故无法确认您是否曾经登陆过，请重新登录。 &nbsp;谢谢！</h2>");

    }

%>
</body>
</html>
