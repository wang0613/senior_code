package cn.p1.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie：客户端会话技术，入门
 */
@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象，绑定数据
        Cookie c = new Cookie("msg","Cookie");
        //2.发送Cookie对象
        response.addCookie(c);

        //细节：可以发送多个Cookie
        Cookie c1 = new Cookie("api","你好");

        //默认状态下是负数，服务器关闭，数据清除
        //设置Cookie的存活时间，持久化存储到硬盘，30秒后自动删除
        c1.setMaxAge(30);
        response.addCookie(c1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
