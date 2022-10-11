package cn.web.p2_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示请求头信息referer
        //直接通过浏览器打开的，不是通过别的超链接
        //此时通过html超链接打开 http://localhost:8080/day11/login.html
        String referer = request.getHeader("referer");
        System.out.println(referer); //null

        //防盗链操作
        if (referer != null) {
            if (referer.contains("/day11")) {
                //如果包含day11说明是正常访问
//                System.out.println("播放电影");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
            }else  {
//                System.out.println("来优酷看电影！！");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("来优酷看电影！！");
            }
        }
    }
}
