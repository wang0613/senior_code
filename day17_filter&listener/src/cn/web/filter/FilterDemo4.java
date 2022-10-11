package cn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *  拦截方式配置：资源被访问的方式
 * 		* 设置dispatcherTypes属性
 * 					1. REQUEST：默认值。浏览器直接请求资源
 * 					2. FORWARD：转发访问资源
 * 					3. INCLUDE：包含访问资源
 * 					4. ERROR：错误跳转资源
 * 					5. ASYNC：异步访问资源
 */
//@WebFilter(value = "/*", dispatcherTypes = DispatcherType.REQUEST) //浏览器直接请求时，会被过滤
@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo4 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        chain.doFilter(req, resp);
        /**
         * * 执行顺序：如果有两个过滤器：过滤器1和过滤器2
         * 			1. 过滤器1
         * 			2. 过滤器2
         * 			3. 资源执行
         * 			4. 过滤器2
         * 			5. 过滤器1
         */
        
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
