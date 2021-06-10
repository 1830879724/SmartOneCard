<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/25
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%
        String path = request.getContextPath();
    %>
    <title>卡入库</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/js/Admin.js"></script>
    <script src="http://api.asilu.com/cdn/jquery.js,jquery.backstretch.min.js" type="text/javascript"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<div>
    <table>
        <tr>
            <h2 style="margin-left: 150px">卡入库</h2>
        </tr>
        <tr>
            <td>开始卡号：</td>
            <td><input id="cstate" type="text" class="layui-input"></td>
        </tr>
        <tr>
            <td>截至卡号：</td>
            <td><input id="cstop" type="text" class="layui-input"></td>
        </tr>
        <tr>
            <td>前缀：</td>
            <td><input onclick="function x() {
              alert(111);
            }" id="qz" type="text" class="layui-input"></td>
        </tr>

        <tr>
            <td><input  type="button" value="入库" class="layui-btn layui-btn-primary"></td>
            <td><input  type="button" value="返回" class="layui-btn layui-btn-primary"></td>
        </tr>
    </table>
</div>
</body>
</html>

