<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/23
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%
        String path = request.getContextPath();
    %>
    <title>新增人员</title>
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
            <h2 style="margin-left: 150px">新增人员</h2>
        </tr>
        <tr>
            <td>人员姓名：</td>
            <td><input id="pname" type="text" class="layui-input"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input id="ppassword" type="password" class="layui-input"></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input id="ppassword1" type="password" class="layui-input"></td>
        </tr>
        <tr>
            <td>所属科室：</td>
            <td>
                <select id="psection" name="psection" lay-verify="required" lay-search="" style=" width:100px; height: 38px" >
                    <option value="">请选择</option>
                    <option value="外科">外科</option>
                    <option value="中医科">中医科</option>
                    <option value="神经内科">神经内科</option>
                    <option value="眼科">眼科</option>
                    <option value="耳鼻喉科">耳鼻喉科</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>所属角色：</td>
            <td>
                <select id="prole" name="prole" lay-verify="required" lay-search="" style="width: 100px;height: 38px">
                    <option value="">请选择</option>
                    <option value="医生">医生</option>
                    <option value="管理员">管理员</option>
                    <option value="收费人员">收费人员</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input onclick="addpeople(this)" type="button" value="提交" class="layui-btn layui-btn-primary"></td>
            <td><input onclick="guanbi()" type="button" value="返回" class="layui-btn layui-btn-primary"></td>
        </tr>
    </table>
</div>
</body>
</html>
