package cn.p2.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session的特点：
 *  1.session用于存储一次会话的多次请求数据，存在服务器端
 *  2.session可以存储任意类型，任意大小的数据
 * session和cookie的区别？
 *  1.session存储于服务端，cookie在客户端
 *  2.session没有数据大小限制，cookie数据有大小限制
 *  3.session数据安全，cookie相对不安全
 */
@WebServlet( "/sessionDemo6")
public class SessionDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println(session);

        session.invalidate();//自杀方法

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
