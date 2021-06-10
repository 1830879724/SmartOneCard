<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/26
  Time: 21:21
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
    <title>领卡</title>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>

<body>
<input type="hidden" id="path" value="<%=path%>">
<form action="${pageContext.request.contextPath}/adminServlet?methodName=CardGets" method="post">
    <div class="layui-form-item">
        <div>查询条件：</div>
        <div class="layui-inline">
            <label class="layui-form-label">申请日期：</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="date" id="adate1" value="${adate}" name="adate1" placeholder="" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid">至</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="date" id="adate2" value="${adate}" name="adate2" placeholder="" autocomplete="off" class="layui-input">
            </div>

        </div>

        <label class="layui-form-label">审核状态:</label>
        <div class="layui-input-inline">
            <select name="astate" lay-verify="required" lay-search="" style="height: 38px">
                <option value="">请选择</option>
                <option <c:if test="${astate=='待审核'}">selected="selected" </c:if> value="待审核">待审核</option>
                <option <c:if test="${astate=='已审核'}">selected="selected" </c:if> value="已审核">已审核</option>
            </select>
        </div>

        <button type="button" class="layui-btn layui-btn-primary">新申请</button>
        <button id="CardGets" type="submit" class="layui-btn layui-btn-primary">查询</button>
    </div>


    </div>

</form>



<table class="layui-table">
    <colgroup>
        <col width="100">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="100">
        <col width="150">
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>申请日期</th>
        <th>申请卡数量</th>
        <th>申请人</th>
        <th>审核状态</th>
        <th>审核人</th>
        <th>审核时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty pageBean}">
        <c:forEach items="${pageBean.list}" var="CardGet">
            <tr>
                <td>${CardGet.rn}</td>
                <td class="adate">${CardGet.adate}</td>
                <td class="anum">${CardGet.anum}</td>
                <td class="apeople">${CardGet.apeople}</td>
                <td class="astate">${CardGet.astate}</td>
                <td class="aauditp">${CardGet.aauditp}</td>
                <td class="aauditdate">${CardGet.aauditdate}</td>
                <td>
                    <input type="button" value="修改">
                </td>

            </tr>
        </c:forEach>
    </c:if>

    <tr>
        <td colspan="9" border="0" style="text-align: center">

            <a href="${pageContext.request.contextPath}/adminServlet?methodName=CardGets&&curPage=1&adate=${adate}&adate1=${adate1}&adate2=${adate2}&apeople=${apeople}&anum=${anum}&aauditp=${aauditp}&aauditdate=${aauditdate}&astate=${astate}
">首页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=CardGets&&curPage=${pageBean.prepage}&adate=${adate}&adate1=${adate1}&adate2=${adate2}&apeople=${apeople}&anum=${anum}&aauditp=${aauditp}&aauditdate=${aauditdate}&astate=${astate}
">上一页</a>
            <a>${pageBean.curPage}/${pageBean.totalPage}</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=CardGets&&curPage=${pageBean.nextPage}&adate=${adate}&adate1=${adate1}&adate2=${adate2}&apeople=${apeople}&anum=${anum}&aauditp=${aauditp}&aauditdate=${aauditdate}&astate=${astate}
">下一页</a>
            <a href="${pageContext.request.contextPath}/adminServlet?methodName=CardGets&&curPage=${pageBean.totalPage}&adate=${adate}&adate1=${adate1}&adate2=${adate2}&apeople=${apeople}&anum=${anum}&aauditp=${aauditp}&aauditdate=${aauditdate}&astate=${astate}
">尾页</a>


        </td>
    </tr>


    </tbody>
</table>




</body>
</html>

