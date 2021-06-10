<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/21
  Time: 23:59
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
    <title>卡入库</title>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/js/Tanchuang.js"></script>

</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form action="${pageContext.request.contextPath}/adminServlet?methodName=insertcx" method="post">
<div class="layui-form-item">
    <div>查询条件：</div>
    <div class="layui-inline">
        <label class="layui-form-label">卡号：</label>
        <div class="layui-input-inline" style="width: 100px;">
            <input id="cradid1" value="${cradid}" type="text" name="cradid1" placeholder="" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid">至</div>
        <div class="layui-input-inline" style="width: 100px;">
            <input id="cradid2" value="${cradid}" type="text" name="cradid2" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-inline">
        <label class="layui-form-label">卡状态:</label>
        <div class="layui-input-inline">
            <select name="cstate" lay-verify="required" lay-search="" style="height: 38px">
                <option value="">请选择</option>
                <option <c:if test="${cstate=='待领用'}">selected="selected" </c:if> value="待领用">待领用</option>
                <option <c:if test="${cstate=='已领用'}">selected="selected" </c:if> value="已领用">已领用</option>

            </select>
        </div>
    </div>
</div>

<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">导入日期：</label>
        <div class="layui-input-inline" style="width: 100px;">
            <input  id="cdate1" value="${cdate}" type="date" name="cdate1" placeholder="" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid">至</div>
        <div class="layui-input-inline" style="width: 100px;">
            <input id="cdate2" value="${cdate}" type="date" name="cdate2" placeholder="" autocomplete="off" class="layui-input">
        </div>
        <button id="insertcx" type="submit" class="layui-btn layui-btn-primary">查询</button>
        <button onclick="addcard()" type="button" class="layui-btn layui-btn-primary">卡入库</button>
    </div>

</div>
</form>


<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="300">
        <col width="300">
        <col width="200">
        <col width="150">
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>卡号</th>
        <th>导入日期</th>
        <th>卡状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty pageBean}">
    <c:forEach items="${pageBean.list}" var="cards">
    <tr style="height: 20px">
        <td>${cards.rn}</td>
        <td class="cradid">${cards.cradid}</td>
        <td class="cdate">${cards.cdate}</td>
        <td class="cstate">${cards.cstate}</td>
        <td hidden class="cid">${cards.cid}</td>
        <td>
            <input type="button" value="删除" onclick="shanchu(this)">
        </td>

    </tr>
    </c:forEach>
    </c:if>

    <tr>
        <td colspan="9" border="0" style="text-align: center">

            <a href="${pageContext.request.contextPath}/adminServlet?methodName=insertcx&&curPage=1&cradid1=${cradid1}&cradid2=${cradid2}&cdate1=${cdate1}&cdate2=${cdate2}&cstate=${cstate}">首页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=insertcx&&curPage=${pageBean.prepage}&cradid1=${cradid1}&cradid2=${cradid2}&cdate1=${cdate1}&cdate2=${cdate2}&cstate=${cstate}">上一页</a>
            <a>${pageBean.curPage}/${pageBean.totalPage}</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=insertcx&&curPage=${pageBean.nextPage}&cradid1=${cradid1}&cradid2=${cradid2}&cdate1=${cdate1}&cdate2=${cdate2}&cstate=${cstate}">下一页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=insertcx&&curPage=${pageBean.totalPage}&cradid1=${cradid1}&cradid2=${cradid2}&cdate1=${cdate1}&cdate2=${cdate2}&cstate=${cstate}">尾页</a>


        </td>
    </tr>
    <tbody>
</table>
</body>
</html>
