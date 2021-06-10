<%--
  Created by IntelliJ IDEA.
  User: ZhangZeMing
  Date: 2020/7/25
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
    %>
    <title>欢迎使用智能一卡通</title>
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">

    <style type="text/css">
        body{
            /*background: url("../images/main2.jpg");*/
            background-color: #66CCCC;

            background-size: 100% 100%;

            /*background-position: center 0;*/
            /*background-repeat: no-repeat;*/
            /*background-attachment: fixed;*/
            /*background-size: cover;*/
            /*-webkit-background-size: cover;*/
            /*-o-background-size: cover;*/
            /*-moz-background-size: cover;*/
            /*-ms-background-size: cover;*/
            /*background-repeat: no-repeat;*/
        }
        .margin{
            margin-top: 5px;
        }
    </style>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">

<div align="center" >
    <div align="center" style="background: antiquewhite ;width: 800px ;height: 350px ;margin-top: 10%;border: 1px solid white;border-radius: 15px"   >

        <div align="left" style="text-indent: 3em; margin-top: 40px; font-size: 20px">
            <label  style="font-weight: bold;color: black  " >欢迎使用智能一卡通系统</label>
        </div>

        <hr style="color: black">

        <div style="margin-top: 30px">
            <tr>
                <td><label style="font-size: 30px">自助终端</label></td>
            </tr>

        </div>

        <div style="margin-top: 30px">
            <tr>
                <td><label onclick="location.href='${pageContext.request.contextPath}/jsp/Login.jsp'" style="font-size: 30px">系统管理端</label></td>
            </tr>

        </div>

    </div>
</div>



</body>
</html>
