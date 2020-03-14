<%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/13
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="ServletUpdateUser" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：<span style="font-style: italic;color: red;font-family: Monaco;">(不可修改)</span></label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly="readonly" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender=='man'}">
                <input type="radio" name="gender" value="man" checked />男
                <input type="radio" name="gender" value="woman"  />女
            </c:if>
            <c:if test="${user.gender=='woman'}">
                <input type="radio" name="gender" value="man"  />男
                <input type="radio" name="gender" value="woman"  checked/>女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄" value="${user.age}"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" >
                <c:if test="${user.address!=null}">
                    <option value="陕西" selected>陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="济南">济南</option>
                    <option value="广州">广州</option>
                    <option value="london">英国伦敦</option>
                    <option value="日本です">日本</option>
                </c:if>
                <c:if test="${user.address==null}">
                    <option value="陕西" selected>陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="济南">济南</option>
                    <option value="广州">广州</option>
                    <option value="london">英国伦敦</option>
                    <option value="日本です">日本</option>
                </c:if>
                <c:if test="${user.address=='陕西'}">
                    <option value="陕西" selected>陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="济南">济南</option>
                    <option value="广州">广州</option>
                    <option value="london">英国伦敦</option>
                    <option value="日本です">日本</option>
                </c:if>
                <c:if test="${user.address=='北京'}">
                    <option value="陕西" >陕西</option>
                    <option value="北京" selected>北京</option>
                    <option value="上海">上海</option>
                    <option value="济南">济南</option>
                    <option value="广州">广州</option>
                    <option value="london">英国伦敦</option>
                    <option value="日本です">日本</option>
                </c:if>
                <c:if test="${user.address=='上海'}">
                    <option value="陕西" >陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海" selected>上海</option>
                    <option value="济南">济南</option>
                    <option value="广州">广州</option>
                    <option value="london">英国伦敦</option>
                    <option value="日本です">日本</option>
                </c:if>
                <c:if test="${user.address=='济南'}">
                    <option value="陕西" >陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="济南" selected>济南</option>
                    <option value="广州">广州</option>
                    <option value="london">英国伦敦</option>
                    <option value="日本です">日本</option>
                </c:if>
                <c:if test="${user.address=='广州'}">
                <option value="陕西" >陕西</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
                <option value="济南">济南</option>
                <option value="广州" selected>广州</option>
                <option value="london">英国伦敦</option>
                <option value="日本です">日本</option>
                </c:if>
                <c:if test="${user.address=='london'}">
                    <option value="陕西" >陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="济南">济南</option>
                    <option value="广州" >广州</option>
                    <option value="london" selected>英国伦敦</option>
                    <option value="日本です">日本</option>
                </c:if>
                <c:if test="${user.address=='日本です'}">
                    <option value="陕西" >陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="济南">济南</option>
                    <option value="广州" >广州</option>
                    <option value="london">英国伦敦</option>
                    <option value="日本です" selected>日本</option>
                </c:if>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码" value="${user.qq}"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址" value="${user.email}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
<div>
    <c:if test="${updateError!=null}">
        <h2 style="text-align: center;color: red;font-weight: bold;font-family: Monaco;">${updateError}</h2>
    </c:if>
</div>
</body>
</html>