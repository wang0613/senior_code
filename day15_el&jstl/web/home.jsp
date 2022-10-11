
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
导入头信息
<%@include file="top.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("msg","message"); //前页面共享数据，还可以获取其他八个内置对象
%>
<%= pageContext.getAttribute("msg")%>
</body>
</html>
