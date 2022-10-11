package cn.web.p2_request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发： 一种在服务器内部的资源跳转方式
 * ***特点：
 * 1.浏览器地址栏没有发生变化
 * 2.只能转发到当前服务器内部资源
 * 3.转发只是一次请求
 */
@WebServlet("/RequestDemo8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo888888被访问了");

        //存储数据到request域中
        request.setAttribute("msg", "hello"); //转发到demo9里面

        //转发到demo9资
        //链式编程，通常写在同一行
        RequestDispatcher dispatcher = request.getRequestDispatcher("/RequestDemo9");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/**
 *  共享数据：
 * 		* 域对象：一个有作用范围的对象，可以在范围内共享数据
 * 	    * request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
 * 		* 方法：
 * 				1. void setAttribute(String name,Object obj):存储数据
 * 				2. Object getAttitude(String name):通过键获取值
 * 				3. void removeAttribute(String name):通过键移除键值对
 */
        this.doPost(request, response);

    }
}
