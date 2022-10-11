package cn.web.p1_servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * GenericServlet抽象类:实现Servlet接口,将其他方法作为空参实现
 * 只将service()方法作为抽象。
 */
@WebServlet("/demo2")
public class ServletDemo2 extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("genericServlet··········");
    }
}
