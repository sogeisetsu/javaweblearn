<%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/9
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" %>
<html>
<head>
    <title>出错了</title>
    <style>
        #tittle{
            text-align: center;
            color: red;
            font-family: Monaco, Menlo, Consolas, "Courier New", monospace;
            font-weight: bold;
            width: fit-content;
            margin-left: auto;
            margin-right: auto;
            margin-top: 30px;
        }
        #time_out{
            margin-top: 50px;
            vertical-align: middle;
        }
        #time_out p{
            font-weight: bold;
            font-size: large;
            text-align: center;
            vertical-align: middle;
        }
        #time_out span{
            color: red;
            font-size: 45px;
            font-family: Monaco;
            font-weight: bolder;
            vertical-align: middle;
        }
    </style>
    <script>
        window.onload=function () {
            //先定义计时器
            var innerText=30;
            function jj() {
                document.getElementById("time_out_number").innerHTML= --innerText;
                if(innerText==0){
                    window.open("http://localhost/day17/","_self")
                }
            }
            window.setInterval(jj,1000);
            console.log("123");
        }
    </script>
</head>
<body>
<h1 id="tittle">出错了&nbsp;&nbsp;呜呜/(ㄒoㄒ)/~~</h1>
<div id="time_out">
    <p>将于<span id="time_out_number">30</span>秒以后跳转到开始页面</p>
</div>
<%="error："+exception.getMessage()%>
<%-- 声明了isErrorPage="true" 的页面才有exception --%>
</body>
</html>
