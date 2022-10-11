package cn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器的执行顺序：
 *      按照类名类名的字符串比较顺序执行，值小的优先执行
 *  WEB XMl配置： <filter-mapping>谁定义在上边，谁先执行
 */
@WebFilter("/*")
public class FilterDemo5 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
