package cn.p1.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 案例：记住上一次访问时间
	1. 需求：
		1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
		2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
	2. 分析：
		1. 可以采用Cookie来完成
		2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
			1. 有：不是第一次访问
				1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
				2. 写回Cookie：lastTime=2018年6月10日11:50:01
			2. 没有：是第一次访问
				1. 响应数据：您好，欢迎您首次访问
				2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    System.out.println("URL编码后："+str_date);
                    cookie.setValue(str_date); //设置值
                    //设施cookie的存活时间
//                    cookie.setMaxAge(60 * 60);
                    response.addCookie(cookie);//发送cookie

                    //响应数据
                    //获取cookie的value 时间
                    String value = cookie.getValue();
                    System.out.println(value);

                    //URL解码
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("URL解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:" + value + "</h1>");
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
            System.out.println("URL编码后："+str_date);

            //创建cookie对象，设置值为当前时间
            Cookie cookie = new Cookie("lastTime",str_date);
            cookie.setValue(str_date); //设置值
            //设施cookie的存活时间
//            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);//发送cookie
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
