package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 * 	1. 访问day17_case案例的资源。验证其是否登录
 * 	3. 如果登录了，则直接放行。
 * 	4. 如果没有登录，则跳转到登录页面，提示"您尚未登录，请先登录"。
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        //1.判断是否是登录相关的路径
        //1.1 获取请求资源的路径
        String uri = request.getRequestURI();

        //2 判断是否包含登录相关的资源路径,注意：要排除 css/js/验证码等一些资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")||uri.contains("/checkCodeServlet")) {
            //包含， 放行让用户去登录，

            chain.doFilter(req, resp);
        }else {
            // 不包含，验证用户是否登录
            //3.session中有没有user对象
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //已经登录放行
                chain.doFilter(req,resp);
            } else {
                //没有登录，跳转到登录页面
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
