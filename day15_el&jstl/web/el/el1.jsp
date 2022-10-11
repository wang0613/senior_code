

<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    jsp默认支持el表达式的。如果要忽略el表达式                      --%>
<%--    1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式--%>
<%--    2. \${表达式} ：忽略当前这个el表达式                          --%>
</head>
<body>
            ${3>4}
        <%--el表达式--%>
         \${6>4}
        <%--忽略当前这个el表达式--%>
</body>
</html>
