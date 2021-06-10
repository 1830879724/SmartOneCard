<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/23
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置密码</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>
<body>
<div>
    <table>
        <tr>
            <h2 style="margin-left: 150px">重置密码</h2>
        </tr>
        <tr>
            <td>旧密码：</td>
            <td><input type="text" class="layui-input"></td>
        </tr>
        <tr>
            <td>新密码：</td>
            <td><input type="text" class="layui-input"></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="text" class="layui-input"></td>
        </tr>


        <tr>
            <td><input type="button" value="提交" class="layui-btn layui-btn-primary"></td>
            <td><input type="button" value="返回" class="layui-btn layui-btn-primary"></td>
        </tr>
    </table>
</div>

</body>
</html>
