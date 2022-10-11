package cn.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * filter过滤器 入门演示
 */

//@WebFilter("/*")  //访问所有资源之前，都会执行该过滤器
public class FilterDemo1 implements Filter {
    /**
     * 初始化方法
     * @param filterConfig
     * @throws ServletException
     */

    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo 执行了！！！！");

        //非常重要的事情：放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * 销毁方法
     */

    public void destroy() {

    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
