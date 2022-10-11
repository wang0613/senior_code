package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<>();//敏感词汇集合

    public void init(FilterConfig config) throws ServletException {


        try {
            //使用io技术读取敏感词汇到集合
            ServletContext servletContext = config.getServletContext();
            String path = servletContext.getRealPath("/WEB_INF/classes/敏感词汇.txt");

            BufferedReader br = new BufferedReader(new FileReader(path));

            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /**
         * 1. 对request对象进行增强。增强获取参数相关方法
         * 2. 放行。传递代理对象
         */
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        //遍历集合
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req, args);
            }
        });

        chain.doFilter(proxy_req, resp);
    }

    public void destroy() {
    }
}

