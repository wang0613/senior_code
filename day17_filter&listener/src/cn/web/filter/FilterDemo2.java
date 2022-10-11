package cn.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 执行顺序:
 * 拦截成功！！！
 * index.jsp run·····
 * 放行成功！！！
 */
//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    /**
     * 每一次的请求被拦截资源时，会执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("拦截成功！！！");
//  过滤器执行流程
//        1. 执行过滤器
//        2. 执行放行后的资源
//        3. 回来执行过滤器放行代码下边的代码
        //放行
        chain.doFilter(req, resp); //放行之后，会执行被拦截的资源，然后在回来执行，过滤器下的代码

        //对response对象的响应消息增强

        System.out.println("放行成功！！！");
    }

    /**
     * 服务器启动后，会创建filter对象，然后调用init方法，只执行一次
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {

        System.out.println("init run ········");
    }

    /**
     * 在服务器关闭后，Filter对象别销毁，如果服务器是正常关闭，则会执行destroy方法，只执行一次
     */
    public void destroy() {
        System.out.println("destroy run ······");
    }

}
