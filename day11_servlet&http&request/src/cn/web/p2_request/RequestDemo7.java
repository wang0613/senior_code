package cn.web.p2_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo7")
public class RequestDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8"); //设置流的编码，解决post方式乱码问题

        //获取参数username
        String name = request.getParameter("username");
        System.out.println(name);
        /**
         * 此时页面的提交方式为post，输入中文出现了乱码 ??????
         * get方式：tomcat 8 已经将get方式乱码问题解决了
         * ​* post方式：会乱码
         * ​	* 解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);

    }
}
