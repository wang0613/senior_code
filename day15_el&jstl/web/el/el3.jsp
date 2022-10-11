
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>域对象值</title>
<%--  ${域名称.键名}：从指定域中获取指定键的值--%>
<%--    1. pageScope		--> pageContext                  --%>
<%--    2. requestScope 	--> request--%>
<%--    3. sessionScope 	--> session--%>
<%--    4. applicationScope --> application（ServletContext）--%>
<%--    * 举例：在request域中存储了name=张三--%>
<%--    * 获取：${requestScope.name}--%>
</head>
<body>
<%
    //在域中存储数据
    pageContext.setAttribute("name","张三");
    request.setAttribute("name","李四");
    session.setAttribute("name","王五");
    application.setAttribute("name","周六");
%>
  ${pageScope.name}
  ${requestScope.name}
  ${sessionScope.name}
  ${applicationScope.name}

<%--省略方式写：会一次从最小域中查找是否有改键的值  --%>
<%--pageContext < request < session < application --%> <br>
  ${name}
</body>
</html>
