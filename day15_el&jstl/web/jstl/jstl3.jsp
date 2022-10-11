<%@ page import="java.util.ArrayList" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<%
    //foreach相当于Java代码的for循环
    //begin:开始值
    //end：结束值
    //var:变量
    //step：步长

    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("aaa");
    arrayList.add("bbb");
    arrayList.add("ccc");
    request.setAttribute("list", arrayList);

%>
<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
    ${i}   ${s.index} ${s.count}   <br>
</c:forEach>
<hr>
<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index}      ${s.count} <br>
</c:forEach>
</body>
</html>
