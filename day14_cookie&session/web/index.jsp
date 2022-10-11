<%--
  jsp：原理就是一个Servlet，自定生成Java代码在work下 index_jsp.java
  jsp脚本:JSP定义Java代码的方式
        1.<%  代码   %>定义的Java代码在service方法中，service方法中可以定义什么，该脚本中就可以定义什么
        2.<%! 代码   %>定义的Java代码，在jsp转换后的Java类的成员位置，（尽量不要用，线程安全问题）
        3.<%= 代码   %>相当于输出语句,会输出到页面上


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello cookie</title>
</head>
<body>

    <%
    System.out.println("hello jsp！");
    int i = 5;

    String contextPath = request.getContextPath();
    out.print(contextPath);   //  /day14_cookie_session虚拟目录
        /*
        out：字符输出流对象,
        response.getWriter()和out.write()的区别：
        response.getWriter.write:无论定义代码的任何位置，都会优先输出
* 在tomcat服务器真正给客户端做出响应之前，会先找response缓冲区数据，再找out缓冲区数据。
         */
    %>


    <%!
        int i = 3;

    %>
    <%= i

    %>

<%--      System.out.println("hello jsp！"); 字符串在HTML中执行--%>

    <%

        response.getWriter().write("response·········"); %>

</body>
</html>
