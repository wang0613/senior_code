package cn.web.p1_servlet;
import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet快速入门：
 * 1.实现Servlet接口，覆盖重写方法
 * 2.配置Servlet 在web.xml中
 *
Servlet实现原理：
 * 1.当服务器端接收到客户端的请求后，会解析请求URL路径，获取访问Servlet的资源路径
 * 2.查找web.xml文件。是否有对应的<url-pattern>标签题内容</url-pattern>与资源路径一致
 * 3.如果有，则会找到对应的<Servlet-class>全类名</>，
 * 4.Tomcat会将字节码文件加载进内存，并创建其对象，
 * 5.调用方法
 */
public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello， Servlet！！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
