package cn.web.p2_request;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取ServletContext：
 * * ServletContext getServletContext();获取ServletContext对象
 */
@WebServlet("/requestDemo10")
public class RequestDemo10 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
        //org.apache.catalina.core.ApplicationContextFacade@1088cef
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
