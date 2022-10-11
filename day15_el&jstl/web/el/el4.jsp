<%@ page import="cn.web.domain.User" %>
<%@ page import="java.util.*" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象数据</title>
<%--   List集合：${域名称.键名[索引]}--%>

<%--    Map集合：--%>
<%--    * ${域名称.键名.key名称}--%>
<%--    * ${域名称.键名["key名称"]}--%>
</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(20);
    user.setBirthday(new Date());
    //往域中存储对象
    request.setAttribute("u", user);

    List<Object> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list", list); //把集合存放到域中

    Map map = new HashMap();
    map.put("name","李四");
    map.put("sex","男");
    request.setAttribute("map",map);

%>
        <%--        获取是通过对象的属性来获取  setter getter方法 --%>
        <h1>获取对象的值</h1>
        ${u} <br>
        ${requestScope.u.name}
        ${u.age}
        <%--            使用自定义的日期格式--%> <br>
        ${u.bitStr}

        <h1>获取list值</h1>
        ${list} <br>
        ${list[0]} <br>
        ${list[100]} <br>  <!--如果角标越界，不会显示 -->
        ${list[2].name} <%-- 通过角标拿出对象，再拿数据 --%>

        <h1>获取map集合</h1>
        ${requestScope.map} <br>
        ${map.name} <br>
        ${map.sex} <br>
        ${map["sex"]}
</body>
</html>
