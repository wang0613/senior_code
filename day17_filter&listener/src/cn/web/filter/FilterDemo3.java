package cn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/hello.jsp") //只有访问hello.jsp时，过滤器才会执行
// 拦截目录： ("/user/*")      访问/user下的所有资源时，过滤器都会被执行
@WebFilter("*.jsp") //3.后缀名拦截
public class FilterDemo3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("hello jsp run");

        chain.doFilter(req, resp);

        System.out.println("hello !!!!!!!!!!!!!!!!!!");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
