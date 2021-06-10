<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/22
  Time: 9:19
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
    <title>卡注销</title>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>

<body>
<input type="hidden" id="path" value="<%=path%>">
<form action="${pageContext.request.contextPath}/adminServlet?methodName=cardcancelcx" method="post">
<div class="layui-form-item">
    <div>查询条件：</div>
    <div class="layui-inline">
        <label class="layui-form-label">卡号：</label>
        <div class="layui-input-inline" style="width: 100px;">
            <input id="scardid1" value="${scardid}" type="text" name="scardid1" placeholder="" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid">至</div>
        <div class="layui-input-inline" style="width: 100px;">
            <input id="scardid2" value="${scardid}" type="text" name="scardid2" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-inline">
        <label class="layui-form-label">卡状态:</label>
        <div class="layui-input-inline">
            <select name="sstate" lay-verify="required" lay-search="" style="height: 38px">
                <option value="">请选择</option>
                <option <c:if test="${sstate=='待注销'}">selected="selected" </c:if> value="待注销">待注销</option>
                <option <c:if test="${sstate=='已注销'}">selected="selected" </c:if> value="已注销">已注销</option>
                <option <c:if test="${sstate=='待销售'}">selected="selected" </c:if> value="待销售">待销售</option>
                <option <c:if test="${sstate=='已销售'}">selected="selected" </c:if> value="已销售">已销售</option>

            </select>
        </div>

        <button type="submit" class="layui-btn layui-btn-primary">查询</button>
    </div>
</div>
</form>


<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="300">
        <col width="200">
        <col width="200">
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>卡号</th>
        <th>卡状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty pageBean}">
        <c:forEach items="${pageBean.list}" var="cardcancel">
            <tr style="height: 30px">
                <td>${cardcancel.rn}</td>
                <td class="scardid">${cardcancel.scardid}</td>
                <td class="sstate">${cardcancel.sstate}</td>
                <td hidden class="sid">${cardcancel.sid}</td>
                <td hidden class="ssellp">${cardcancel.ssellp}</td>
                <td>
                    <input type="button" value="注销">
                </td>

            </tr>
        </c:forEach>
    </c:if>


    <tr>
        <td colspan="9" border="0" style="text-align: center">

            <a href="${pageContext.request.contextPath}/adminServlet?methodName=cardcancelcx&&curPage=1&scardid1=${scardid1}&scardid2=${scardid2}&sstate=${sstate}
">首页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=cardcancelcx&&curPage=${pageBean.prepage}&scardid1=${scardid1}&scardid2=${scardid2}&sstate=${sstate}
">上一页</a>
            <a>${pageBean.curPage}/${pageBean.totalPage}</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=cardcancelcx&&curPage=${pageBean.nextPage}&scardid1=${scardid1}&scardid2=${scardid2}&sstate=${sstate}
">下一页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=cardcancelcx&&curPage=${pageBean.totalPage}&scardid1=${scardid1}&scardid2=${scardid2}&sstate=${sstate}
">尾页</a>


        </td>
    </tr>

    </tbody>
</table>




</body>
</html>
