package cn.web.p2_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//HttpServlet演示获取【请求头】信息
@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 演示获取请求头消息 user——Agent
         * user——Agent：浏览器告诉服务器，我访问你使用的浏览器版本信息
         */
        String agent = request.getHeader("user-agent"); //不区分大小写


        //判断agent的浏览器版本信息
        if (agent.contains("Chrome")) {
            System.out.println("谷歌来了!!!!!!!!");
        } else if (agent.contains("Edg")) {
            System.out.println("edge!!!!!!!!");
        } else if (agent.contains("FireFox")) {
            System.out.println("FireFOx!!!!!!!!");

        }
    }
}
