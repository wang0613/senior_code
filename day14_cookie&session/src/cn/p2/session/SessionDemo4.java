package cn.p2.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session细节 2：客户端不关闭，服务器关闭后，再次开启服务器访问，两次获取的session是同一个吗？
 * 不是，服务端关闭后，session对象被销毁
 * -----如果要确保数据不丢失？？使用session的钝化
 * session钝化：*在服务器正常关闭之前，将session对象序列化到硬盘上
 * session活化：*在服务器启动后，将session文件转化为内存中的session对象即可
 */
@WebServlet("/sessionDemo4")
public class SessionDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);
        //org.apache.catalina.session.StandardSessionFacade@41612
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
