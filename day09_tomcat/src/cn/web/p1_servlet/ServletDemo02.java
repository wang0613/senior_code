package cn.web.p1_servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet的方法：
 * Servlet生命周期：
 *  1.被创建 ：执行init方法，只执行一次，说明Servlet在内存中只存在一个对象
 *      *Servlet什么时候被创建？
 *         默认情况下,第一次被访问时，Servlet被创建
 *         可以配置执行Servlet的创建时机，在<servlet>标签下配置
 *  2.提供服务：执行service方法，执行多次
 *      * 每次访问Servlet时，Service方法都会被调用一次。
 *  3.被销毁：执行destroy：执行一次
 *      * Servlet被销毁时执行。服务器关闭时，Servlet被销毁
 * 		* 只有服务器正常关闭时，才会执行destroy方法。
 * 		* destroy方法在Servlet被销毁之前执行，一般用于释放资源
 */
public class ServletDemo02 implements Servlet {
    /**
     * init：初始化方法
     * 在Servlet被创建时，执行，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init·····");
    }

    /**
     * ServletConfig：获取ServletConfig对象
     * ServletConfig：Servlet配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法：提供服务的方法
     * 每一次Servlet被访问时，执行，执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service ······");
    }

    /**
     * getServletInfo：获取Servlet的一些信息：版本，坐着等····
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * destroy：销毁方法
     * 在服务器正常关闭时，执行，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy······");
    }
}
