package cn.web.p2_servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext：代表整个web应用，可以和程序容器进行通信
 */

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.通过request对象来获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
        System.out.println("------------------");
        //2.通过HttpServlet来获取
        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext1);

        System.out.println(servletContext == servletContext1);//true
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
