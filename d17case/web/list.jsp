<%--
  Created by IntelliJ IDEA.
  User: 苏月晟
  Date: 2020/3/12
  Time: 11:10
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
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function del(id) {
            if(confirm("确定要删除吗？") == true){
                location.href="${pageContext.request.contextPath}/ServletDeleteById?id="+id;
            }
        }
        window.onload=function () {
            document.getElementById("firstCb").onclick=function(){ //全选
                var elementsByName = document.getElementsByName("uid");
                for(var i =0;i<elementsByName.length;i++){
                    elementsByName[i].checked=this.checked;
                }
            };

            document.getElementById("del").onclick=function () { //选择
                var elementsByName = document.getElementsByName("uid");
                var flag=false;
                for(var i =0;i<elementsByName.length;i++){
                    if(elementsByName[i].checked){
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    document.getElementById("form").submit();
                }
            }
            document.getElementById("showAll").onclick=function () {
                location.href="${pageContext.request.contextPath}/ServletFindUserByPage?currentPage=1&rows=5"
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="margin-bottom: 20px;height: 30px">
        <div style="float: left">
            <form class="form-inline" action="${pageContext.request.contextPath}/ServletFindUserByPage?currentPage=1&rows=5" method="post">
                <div class="form-group">
                    <label for="exampleInputName2">姓名</label>
                    <input type="text" class="form-control" id="exampleInputName2" name="name" value="${name}">
                </div>
                <div class="form-group">
                    <label for="exampleInputName1">籍贯</label>
                    <input type="text" class="form-control" id="exampleInputName1"  name="address" value="${address}" >
                </div>
                <div class="form-group">
                    <label for="exampleInputName2">E-mail</label>
                    <input type="text" class="form-control" id="exampleInputName3" name="email" value="${email}" >
                </div>
                <button type="submit" class="btn btn-default">查询</button>
                <button type="button" class="btn btn-default" id="showAll" >显示全部</button>
            </form>
        </div>
        <div style="float: right">
            <a class="btn btn-primary" href="add.jsp">添加联系人</a>
            <a class="btn btn-primary"  id="del" href="javascript:void(0)">删除选中联系人</a>
        </div>
    </div>
    <form id="form" method="post" action="ServletDelSelect">
        <table border="1" class="table table-bordered table-hover" style="margin-top: 20px">
            <tr class="success">
                <th><input type="checkbox" id="firstCb">全选</th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${BeanPage.list}" var="item" varStatus="s">
                <tr>
                    <td><input type="checkbox" value="${item.id}" name="uid"></td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.gender}</td>
                    <td>${item.age}</td>
                    <td>${item.address}</td>
                    <td>${item.qq}</td>
                    <td>${item.email}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/ServletFindUser?id=${item.id}">修改</a>&nbsp;<a
                            class="btn btn-default btn-sm" href="javascript:del(${item.id});">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
<div>
    <c:if test="${deleteError!=null}">
        <h2 style="text-align: center;color: red;">${deleteError}</h2>
    </c:if>
    <c:if test="${deleteSelectError!=null}">
        <h2 style="text-align: center;color: red;">${deleteSelectError}</h2>
    </c:if>
</div>
<div class="container" align="center">
    <nav aria-label="Page navigation">
        <ul class="pagination pagination-lg">
            <c:if test="${BeanPage.currentPage==1}">
                <li class="disabled">
            </c:if>
            <c:if test="${BeanPage.currentPage!=1}">
                <li>
            </c:if>
                <a href="${pageContext.request.contextPath}/ServletFindUserByPage?currentPage=${BeanPage.currentPage-1}&rows=5&name=${name}&address=${address}&email=${email}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${BeanPage.totalPage}" var="i" varStatus="s">
                <c:if test="${BeanPage.currentPage==i}">
                    <li class="active"><a href="${pageContext.request.contextPath}/ServletFindUserByPage?currentPage=${i}&rows=5&name=${name}&address=${address}&email=${email}">${i}</a></li>
                </c:if>
                <c:if test="${BeanPage.currentPage!=i}">
                    <li><a href="${pageContext.request.contextPath}/ServletFindUserByPage?currentPage=${i}&rows=5&name=${name}&address=${address}&email=${email}">${i}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${BeanPage.currentPage==BeanPage.totalPage}">
                <li class="disabled">
            </c:if>
            <c:if test="${BeanPage.currentPage!=BeanPage.totalPage}">
                <li>
            </c:if>
                <a href="${pageContext.request.contextPath}/ServletFindUserByPage?currentPage=${BeanPage.currentPage+1}&rows=5&name=${name}&address=${address}&email=${email}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-family: Monaco;font-size: large;vertical-align: middle;line-height: 46px;font-weight: bolder;margin-left: 20px">
                共有${BeanPage.totalCount}个用户，分成了${BeanPage.totalPage}页显示
            </span>
        </ul>
    </nav>

</div>
</body>
</html>

