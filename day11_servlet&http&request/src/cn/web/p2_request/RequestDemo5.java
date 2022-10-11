package cn.web.p2_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/RequestDemo5")
public class RequestDemo5 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示请求体 ：只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
        //使用register.html注册表单演示
        //1.获取流对象
        BufferedReader reader = request.getReader();
        //2.拿数据
        String line = null;
        while ((line = reader.readLine())!= null) {
            System.out.println(line);
            //username=aaa&password=abc

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
