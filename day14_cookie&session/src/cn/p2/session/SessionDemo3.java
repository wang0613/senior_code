package cn.p2.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Session细节问题:当客户端关闭后，服务端不关闭，两次获取的Session是否为同一个？？？
 * 默认情况下不为同一个,因为关闭后请求头发生改变了,session是依赖于cookie的
 * ---------------------------
 * 如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
 */
@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        System.out.println("session = " + session);
        // org.apache.catalina.session.StandardSessionFacade@15ba4df
        //关闭后浏览器重新访问，内存地址值不相同

        //希望客户端关闭后，session也能相同
        Cookie cookie = new Cookie("JSESSIONID",session.getId());//设置cookie请求头
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
