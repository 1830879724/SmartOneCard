<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/22
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%
        String path = request.getContextPath();
    %>
<meta charset="UTF-8">
<title>人员管理</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/js/Update.js"></script>
        <script src="${pageContext.request.contextPath}/js/Tanchuang.js"></script>

</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form action="${pageContext.request.contextPath}/adminServlet?methodName=chaxun" method="post">
<div class="layui-form-item">
    <div style="font-size: 20px;height:27px">查询条件：</div>
    <div class="layui-inline">
        <label class="layui-form-label">人员姓名：</label>
        <div class="layui-input-inline" style="width: 100px;">
            <input id="pname" value="${pname}" type="text" name="pname" autocomplete="off" class="layui-input">
        </div>

        <label class="layui-form-label">科室:</label>
        <div class="layui-input-inline">
            <select name="psection" lay-verify="required" lay-search="" style=" width:100px; height: 38px" >
                <option value="">请选择</option>
                <option <c:if test="${psection=='外科'}">selected="selected" </c:if> value="外科">外科</option>
                <option <c:if test="${psection=='中医科'}">selected="selected" </c:if> value="中医科">中医科</option>
                <option <c:if test="${psection=='神经内科'}">selected="selected" </c:if> value="神经内科">神经内科</option>
                <option <c:if test="${psection=='眼科'}">selected="selected" </c:if> value="眼科">眼科</option>

            </select>
        </div>

        <label class="layui-form-label">角色:</label>
        <div class="layui-input-inline">
            <select name="prole" value="${prole}" lay-verify="required" lay-search="" style="width: 100px;height: 38px">
                <option value="">请选择</option>
                <option <c:if test="${prole=='医生'}">selected="selected" </c:if> value="医生">医生</option>
                <option <c:if test="${prole=='管理员'}">selected="selected" </c:if> value="管理员">管理员</option>
                <option <c:if test="${prole=='收费人员'}">selected="selected" </c:if> value="收费人员">收费人员</option>
            </select>
        </div>
    </div>


</div>


<label class="layui-form-label">状态:</label>
<div class="layui-input-inline">
    <select name="pstate" value="${pstate}" lay-verify="required" lay-search="" style="width: 100px;height: 38px">
        <option value="">请选择</option>
        <option <c:if test="${pstate=='启用'}">selected="selected" </c:if> value="启用">启用</option>
        <option <c:if test="${pstate=='禁用'}">selected="selected" </c:if> value="禁用">禁用</option>
        <option <c:if test="${pstate=='已删除'}">selected="selected" </c:if> value="已删除">已删除</option>
    </select>
</div>

<button id="chaxun" style="margin-left: 91px;width: 100px" type="submit" class="layui-btn layui-btn-primary">查询</button>
<button style="margin-left: 29px;width: 100px" type="button" class="layui-btn layui-btn-primary" onclick="addManagement()">新增人员</button>
</form>


<table class="layui-table">
    <colgroup>
        <col width="200">
        <col width="200">
        <col width="200">
        <col width="200">
        <col width="200">
        <col width="250">
    </colgroup>
    <thead>
    <tr>
        <td>序号</td>
        <td>人员姓名</td>
        <td>科室</td>
        <td>角色</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty pageBean}">
        <c:forEach items="${pageBean.list}" var="userss">
            <tr style="height: 20px">
                <td>${userss.rn}</td>
                <td class="pname">${userss.pname}</td>
                <td class="psection">${userss.psection}</td>
                <td class="prole">${userss.prole}</td>
                <td class="pstate">${userss.pstate}</td>
                <td hidden class="paccount">${userss.paccount}</td>
                <td>
                    <c:if test="${userss.pstate!='已删除'}">
                    <c:choose>
                        <c:when test="${userss.pstate=='禁用'}">
                            <input type="button" value="启用" onclick="update(this)" />
                        </c:when>
                        <c:otherwise>
                            <input type="button" value="禁用" onclick="update(this)" />
                        </c:otherwise>
                    </c:choose>
                    <input type="button" value="修改" onclick="alter(this)">
                    <input type="button" value="删除" onclick="shanchu(this)">
                    <input type="button" value="重置密码" onclick="rest(this)">
                    </c:if>
                </td>

            </tr>
        </c:forEach>
    </c:if>

    <tr>
        <td colspan="9" border="0" style="text-align: center">

            <a href="${pageContext.request.contextPath}/adminServlet?methodName=chaxun&&curPage=1&prole=${prole}&pstate=${pstate}&pname=${pname}&psection=${psection}&paccount=${paccount}">首页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=chaxun&&curPage=${pageBean.prepage}&prole=${prole}&pstate=${pstate}&pname=${pname}&psection=${psection}&paccount=${paccount}">上一页</a>
            <a>${pageBean.curPage}/${pageBean.totalPage}</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=chaxun&&curPage=${pageBean.nextPage}&prole=${prole}&pstate=${pstate}&pname=${pname}&psection=${psection}&paccount=${paccount}">下一页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=chaxun&&curPage=${pageBean.totalPage}&prole=${prole}&pstate=${pstate}&pname=${pname}&psection=${psection}&paccount=${paccount}">尾页</a>


        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
