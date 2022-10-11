package cn.web.p2_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * *	1. request和response对象是由服务器创建的。我们来使用它们
 * * 	2. request对象是来获取请求消息，response对象是来设置响应消息
 */

//演示HttpServletRequest对象来获取【请求行】数据
@WebServlet("/request")
public class RequestDemo1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 获取请求行数据  * GET /day11/demo1?name=zhangsan HTTP/1.1
         * 		1. 获取请求方式 ：GET
         * 			* String getMethod()
         * 		2. (重点)获取虚拟目录：/day11
         * 			* String getContextPath()
         * 		3. 获取Servlet路径: /demo1
         * 			* String getServletPath()
         * 		4. 获取get方式请求参数：name=zhangsan
         * 			* String getQueryString()
         * 		5. (重点)获取请求URI：/day14/demo1
         * 			* String getRequestURI():		/day14/demo1
         * 			* StringBuffer getRequestURL()  http://localhost/day14/demo1
         *      * URL:统一资源定位符 ： http://localhost/day14/demo1
         * 		* URI：统一资源标识符 : /day14/demo1
         *      6. 获取协议及版本：HTTP/1.1
         * 			* String getProtocol()
         * 		7. 获取客户机的IP地址：
         * 			* String getRemoteAddr()
         */
        //1.获取请求方式 : GET
        String method = request.getMethod();
        System.out.println("method = " + method);
        //2.获取虚拟目录 :/day11
        String ContextPath = request.getContextPath();
        System.out.println("ContextPath = " + ContextPath);
        //3. 获取Servlet请求路径:  /request
        String servletPath = request.getServletPath();
        System.out.println("servletPath = " + servletPath);
        //4. 获取get方式请求参数：name=zahngsan
        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);
        //5.获取请求URI：/day11/request 获取URL：http://localhost:8080/day11/request
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        StringBuffer URL = request.getRequestURL();
        System.out.println("URL = " + URL);
        //6. 获取协议及版本： HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);
        //7.获取客户机的IP地址：0:0:0:0:0:0:0:1
        String addr = request.getRemoteAddr();
        System.out.println("addr = " + addr);

    }
}
