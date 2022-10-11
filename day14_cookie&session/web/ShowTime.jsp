<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowTime</title>
</head>
<body>
<%
    //1.设置编码
    response.setContentType("text/html;charset=UTF-8");
    //2.获取所有的cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false;//没有cookie为lastTime
    //3.遍历cookie数组
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            //3.获取cookie的名称
            String name = cookie.getName();
            //4.判断cookie的名称是否为lastTime
            //5.有，该cookie
            if ("lastTime".equals(name)) {
                flag = true;

                //设置cookie的value
                //获取当前时间的字符串，重新设置cookie的值，重新发送
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);//格式化时间

                System.out.println(str_date);
                //URL编码
                str_date = URLEncoder.encode(str_date, "utf-8");
                System.out.println("URL编码后：" + str_date);
                cookie.setValue(str_date); //设置值
                //设施cookie的存活时间
//                    cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);//发送cookie

                //响应数据
                //获取cookie的value 时间
                String value = cookie.getValue();
                System.out.println(value);

                //URL解码
                value = URLDecoder.decode(value, "utf-8");
                System.out.println("URL解码后：" + value);
%>
<h1>欢迎回来，您上次访问时间为: <%=value %>
</h1>
<%
                break;
            }
        }
    }

    if (cookies == null || cookies.length == 0 || flag == false) {
        //第一次访问
        //设置cookie的value
        //获取当前时间的字符串，重新设置cookie的值，重新发送
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");
        String str_date = sdf.format(date);//格式化时间

        System.out.println(str_date);
        //URL编码
        str_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("URL编码后：" + str_date);

        //创建cookie对象，设置值为当前时间
        Cookie cookie = new Cookie("lastTime", str_date);
        cookie.setValue(str_date); //设置值
        //设施cookie的存活时间
//            cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);//发送cookie

%>
<h1>您好，欢迎您首次访问</h1>

<%
    }

%>


</body>
</html>
