<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--算数运算符 div mod--%>
<%--比较运算符 > < >= <= == !=  --%>
<%--逻辑运算符 and or not --%>
<%--空运算符   empty --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el运算符</title>
</head>
<body>

        <h1>算数运算符</h1>
        ${ 3+4} <br>
        ${3 div 1} <br>
        ${3 / 1 } <br>
        <h1>比较运算符</h1>
        ${ 3 == 4} <br>
        ${3 > 1} <br>
        ${3 != 1 } <br>
        <h1>逻辑运算符</h1>
        ${ 3 > 4 && 3 < 4   } <br>
        ${3 > 1 or 4 < 5 } <br>
        <h1>空运算符：用于判断字符串，集合，数组对象是否为null，长度是否为0</h1>
        <%
                String str = "abc";
                request.setAttribute("str",str);

                List list = new ArrayList();
                request.setAttribute("list",list);
        %>
        <%--        el运算符只能在域中拿数据   --%>
        ${empty str}
        ${ not empty str}
        ${ not empty list} <%-- 判断集合中有无数据 --%>



</body>
</html>
