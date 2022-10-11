package cn.web.p1_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet：对http协议的一种封装，简化操作,
 * http有八种请求方式，get和post常用
 * HttpServlet提供了服务的方法 doGet() doPost()
 *       注意：
 *       通过浏览器直接请求是get请求方式
 *       html表单可以通过post请求
 */
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {
    /**
     *  * HTTP：超文本传输协议
     *  * 传输协议：定义了，客户端和服务端通信时，发送数据的格式
     *  * 特点：
     *  *  1.基于Tcp/Ip的高级协议
     *  *  2.默认端口号 80
     *  *  3.基于请求/响应模型 ：一次请求对应一次响应
     *  *  4.无状态的：每次请求之间相互独立，不同交互数据
     *  */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget·······");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post·······");
    }
}
