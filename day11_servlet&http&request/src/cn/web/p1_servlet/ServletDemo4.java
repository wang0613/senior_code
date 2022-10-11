package cn.web.p1_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//三个资源路径都可以访问到
//@WebServlet({"/d4","/dd4","/ddd4"})
//@WebServlet("/user/demo4")
//@WebServlet("/user/*") //*通配符优先级较低，找不到才会执行它
@WebServlet("*.do")    //*.do后缀名
public class ServletDemo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("demo4·····");
        //打印HttpServletRequest如下
        //通过Tomcat查询到RequestFacade类是继承自HttpServletRequest接口
//        org.apache.catalina.connector.RequestFacade@84227
        System.out.println(req);



    }
}
