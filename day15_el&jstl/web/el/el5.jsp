


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>
    <%-- 获取request对象 --%>
    ${pageContext.request} <br>

    <h4>在jsp页面动态获取jsp虚拟目录</h4>
    <%-- 通过request对象获取虚拟目录 --%>
    ${pageContext.request.contextPath}

</body>
</html>
