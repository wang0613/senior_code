package cn.web.p2_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//HttpServlet演示获取【请求头】信息
@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 演示获取所有请求头信息
         */
        //1.获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
       while (headerNames.hasMoreElements()) {
           String name = headerNames.nextElement(); //获取所有名称
           String value = request.getHeader(name);
           //通过getHeader来获取value值
           System.out.println(name +"·····"+value);
       }
    }
}
