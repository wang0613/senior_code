package cn.web.p1_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
服务器输出字符数据到浏览器
 */
@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取对象之前，设置流的编码，ISO-8859设置为GBK
//        response.setCharacterEncoding("GBK");

        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        //设置响应头content-type编码为utf-8
        response.setHeader("content-type","text/html;charset=utf-8");//告诉浏览器使用utf-8

        //简单的形式，设置编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据
        pw.write("<h1>hello response !!! </h1>");
        pw.write("你好！！"); //出现了乱码问题，浏览器默认GBK中文码表


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
