package cn.web.p1_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ** 案例：
 * 	1. 完成重定向
 * 	重定向的特点：
 * 	    1.地址栏发生变化
 * 	    2.重定向可以访问其他站点的资源
 * 	    3.重定向是两个请求，不能使用request域共享数据
 * 	转发的特点：
 * 	    1.转发地址栏路径不变
 * 	    2.转发只能访问当前服务器下的资源
 * 	    3.转发只能是一次请求，可以使用request域共享数据
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("responseDemo1 run·······");

        //访问responseDemo1 会自动跳转到responseDemo2
        //1.设置状态码302
//        response.setStatus(302);
//        //2.设置响应头 s为本地  s1为需要跳转的位置
//        response.setHeader("location","/day13_response/responseDemo2");

        //动态获取虚拟目录
        String path = request.getContextPath();
        System.out.println(path);
        //简单的重定向方法，不需要设置状态码
        response.sendRedirect(path+"/responseDemo2");

//        response.sendRedirect("http://www.itcast.cn"); //重定向可以访问其他资源


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
