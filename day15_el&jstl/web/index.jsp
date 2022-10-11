<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp"  language="java" buffer="8kb" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- page指令：配置jsp页面，键值对存在的属性值
          contentType：等同于response.setContentType();
              1.设置响应体的MIME类型，以及字符集
              2.设置当前jsp页面的编码
          inport:导包
          errorPage：页面发生异常后，会自动跳转到指定页面
          isErrorPage：标识当前页面是不是错误页面
              * true：是，可以使用内置对象exception
			  * false：否。默认值。不可以使用内置对象exception
--%>
<%--include指令: 页面包含的，导入页面的资源文件
--%>
<%--taglib指令：导入jsp库的资源
        prefix:前缀，自定义的
--%>

<html>
  <head>
    <title>jsp</title>
  </head>
  <body>
  <%
    List<String> list = new ArrayList();
    int i = 3/0;
  %>
  </body>
</html>
