<%@ page import="cn.web.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>

<%--* 需求：在request域中有一个存有User对象的List集合。--%>
<%--需要使用jstl+el将list集合数据展示到jsp页面的表格table中--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>练习</title>
</head>
<body>
<%
    List<User> list = new ArrayList<>();
    list.add(new User("张三", 23, new Date()));
    list.add(new User("李四", 23, new Date()));
    list.add(new User("王五", 23, new Date()));

    request.setAttribute("list", list);
%>
<table border="1" width="500" align="center">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>生日</td>
    </tr>

    <c:forEach items="${list}" var="user" varStatus="s">

        <c:if test="${s.count %2 ==0}">
            <tr bgcolor="#7fffd4">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.bitStr}</td>
            </tr>
        </c:if>

        <c:if test="${s.count%2 !=0}">
            <tr bgcolor="#00ffff">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.bitStr}</td>
            </tr>
        </c:if>


    </c:forEach>


</table>
</body>
</html>
