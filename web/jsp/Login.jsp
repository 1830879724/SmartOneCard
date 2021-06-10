<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/21
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工作人员登录界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
    <!--[if IE]>
    <script src="${pageContext.request.contextPath}/js/html5.js"></script>
    <![endif]-->
</head>

<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/js/log.js"></script>

<%
    String path = request.getContextPath();
//    out.write(path);
%>


<body>
<input type="hidden" id="path" value="<%=path%>">
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>智能一卡通系统登录</h3>
                <form method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input id="paccount" name="paccount" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input id="ppassword" name="ppassword" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" type="password" placeholder="请输入密码">
                    </div>
                    <div class="yzm">
                        <span class="u_user"></span>
                        <input id="vCode" name="vCode" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入验证码">
                    </div>
                    <div>
                            <td>
                                <img id="vCodeImg" style="width: 110px;height: 35px" src="${pageContext.request.contextPath}/verifyCodeServlet" onclick="changeImag()">
                            </td>
                            <td><label onclick="changeImag()">看不清，请刷新</label></td>
                    </div>
                    <div class="mb2">
                        <a class="act-but submit" style="color: #FFFFFF" onclick="jqAjax()" >登录</a>
<%--                        <input class="act-but submit" type="button" style="color: #FFFFFF" onclick="jqAjax()" value="jq登录"><--%>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
</body>
</html>
