<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/21
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理端主界面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/js/Update.js"></script>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">XXXXXXX医院后台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
<%--                    欢迎XXX|XXX--%>
                    <span>欢迎${list.pname}</span>
                </a>
            </li>
            <li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">

    <div class="layui-side-scroll">
    <c:if test="${not empty menuMap}">
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <c:forEach items="${menuMap}" var="muMap">
                <li class="layui-nav-item ">
                <a>${muMap.key}</a>
                <dl class="layui-nav-child">
                <c:forEach items="${muMap.value}" var="list">
                    <dd><a onclick="dian(this)" title="${list.url}" >${list.pname}</a></dd>
                </c:forEach>
                </dl>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    </div>


    </div>


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="text-align: center">
        <iframe id="iframe" width="100%" height="99%" src=""></iframe>
        </div>

    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
       XXXXXXXXXXXXX
    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
<%--</body>--%>


<%--<body>--%>
</html>
