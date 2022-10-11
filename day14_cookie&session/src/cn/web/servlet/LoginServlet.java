package cn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码request
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //3.先判断验证码是否正确
        //3.1获取存入session中的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //一次性验证码，获取之后立即删除
        session.removeAttribute("checkCode_session");
        //3.2比较：session值和输入的值记性忽略大小写进行比较
        if (checkCode_session.equalsIgnoreCase(checkCode)) {
            //判断用户名和密码是否一致,使用UserDao 调用数据库
            if ("张三".equals(username) && "123".equals(password)) {
                //登录成功，存储用户信息
                session.setAttribute("user", username);
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                //验证码错误 1.存储提示信息到request
                request.setAttribute("login_error", "用户名或者密码错误");
                //2.转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else {
            //验证码错误 1.存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            //2.转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
