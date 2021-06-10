<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/22
  Time: 10:49
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
    <title>卡查询</title>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>

<body>
<input type="hidden" id="path" value="<%=path%>">
<form action="${pageContext.request.contextPath}/adminServlet?methodName=CardInquirecx" method="post">
<div class="layui-form-item">
    <div>查询条件：</div>
    <div class="layui-inline">
        <label class="layui-form-label">卡号：</label>
        <div class="layui-input-inline" style="width: 100px;">
            <input id="scardid" value="${scardid}" type="text" name="scardid" placeholder="" autocomplete="off" class="layui-input">
        </div>

        <label class="layui-form-label">卡状态:</label>
        <div class="layui-input-inline">
            <select name="sstate" lay-verify="required" lay-search="" style="height: 38px">
                <option value="">请选择</option>
                <option <c:if test="${sstate=='已销售'}">selected="selected" </c:if> value="已销售">已销售</option>
                <option <c:if test="${sstate=='待销售'}">selected="selected" </c:if> value="待销售">待销售</option>

            </select>
        </div>

        <label class="layui-form-label">领用人:</label>
        <div class="layui-input-inline">
            <select name="ssellp" lay-verify="required" lay-search="" style="height: 38px">
                <option value="">请选择</option>
                <option <c:if test="${ssellp=='张三'}">selected="selected" </c:if> value="张三">张三</option>
                <option <c:if test="${ssellp=='李四'}">selected="selected" </c:if> value="李四">李四</option>

            </select>
        </div>

    </div>

</div>
<button style="margin-left: 500px" type="submit" class="layui-btn layui-btn-primary">查询</button>

</form>


<table class="layui-table">
    <colgroup>
        <col width="100">
        <col width="200">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="100">
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>卡号</th>
        <th>卡状态</th>
        <th>领用人</th>
        <th>就诊人</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty pageBean}">
        <c:forEach items="${pageBean.list}" var="CardInquire">
            <tr style="height: 30px">
                <td>${CardInquire.rn}</td>
                <td class="scardid">${CardInquire.scardid}</td>
                <td class="sstate">${CardInquire.sstate}</td>
                <td class="ssellp">${CardInquire.ssellp}</td>
                <td class="aname">${CardInquire.aname}</td>
                <td>
                    <input type="button" value="查询">
                </td>

            </tr>
        </c:forEach>
    </c:if>


    <tr>
        <td colspan="9" border="0" style="text-align: center">

            <a href="${pageContext.request.contextPath}/adminServlet?methodName=CardInquirecx&&curPage=1&aname=${aname}&scardid=${scardid}&ssellp=${ssellp}&sstate=${sstate}
">首页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=CardInquirecx&&curPage=${pageBean.prepage}&aname=${aname}&scardid=${scardid}&ssellp=${ssellp}&sstate=${sstate}
">上一页</a>
            <a>${pageBean.curPage}/${pageBean.totalPage}</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=CardInquirecx&&curPage=${pageBean.nextPage}&aname=${aname}&scardid=${scardid}&ssellp=${ssellp}&sstate=${sstate}
">下一页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=CardInquirecx&&curPage=${pageBean.totalPage}&aname=${aname}&scardid=${scardid}&ssellp=${ssellp}&sstate=${sstate}
">尾页</a>


        </td>
    </tr>
    </tbody>
</table>


</body>
</html>
