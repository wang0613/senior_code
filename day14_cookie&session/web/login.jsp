<%--
  Created by IntelliJ IDEA.
  User: 王海龙
  Date: 2020/5/31
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {

                //点击图片切换验证码,添加时间戳
                this.src= "/day14/checkCodeServlet?time="+new Date().getTime();

            }
        }
    </script>

    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action="/day14/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>

        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>

        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>

        <tr>
            <td colspan="2"><img  id="img" src="/day14/checkCodeServlet"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>

    </table>

    <div><%= request.getAttribute("cc_error") == null ?
            " ":request.getAttribute("cc_error")%></div>
    <div><%= request.getAttribute("login_error")== null ?
            " " :request.getAttribute("login_error")%></div>
<%--    ${requestScope.cc_error}使用el表达式替换 --%>
</form>
</body>
</html>
