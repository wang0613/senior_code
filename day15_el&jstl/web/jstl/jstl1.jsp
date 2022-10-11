<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL if标签</title>
</head>
<body>
<%--    c:if标签
            test ：必须属性，里面接收boolean表达式
                如果test表达式为true：显示标签题内容，false则不显示
        一般情况下，text结合el表达式一起使用


--%>
    <c:if test="true">jstl if语句执行了！！</c:if>

<%
    //判断request域中一个list集合是否为空，如果不为空则显示遍历集合
    List list = new ArrayList();
    list.add("wangcai");
    request.setAttribute("list",list);

    request.setAttribute("number",5);

%>
    <c:if test="${not empty list}">
        遍历集合````
    </c:if>

<c:if test="${number % 2 != 0}">
    number为基数
</c:if>
</body>
</html>
