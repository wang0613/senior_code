package cn.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * * ServletContextListener:监听ServletContext对象的创建和销毁
 * * 方法：
 * void contextDestroyed(ServletContextEvent sce) ：ServletContext对象被销毁之前会调用该方法
 * void contextInitialized(ServletContextEvent sce) ：ServletContext对象创建后会调用该方法
 */
@WebListener
public class ListenerDemo1 implements ServletContextListener {


    /**
     * 监听ServletContext对象创建的，ServletContext对象在服务器启动后自动创建
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建了！！");
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁，当服务器正常关闭后该方法被调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了！！");

    }
}
