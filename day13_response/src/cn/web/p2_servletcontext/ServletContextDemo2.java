package cn.web.p2_servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext功能：
 * 获取MIME类型：
 *  MIME类性:是在互联网通信过程中定义的一种类型
 *      格式：大类型/小类型   例如：text/html
 *   获取：String getMimeType(String file)
 */

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        //2.定义文件名称
        String fileName = "a.jpg";
        //3.获取MIME类型
        String mimeType = context.getMimeType(fileName);
        System.out.println("mimeType = " + mimeType); //image/jpeg
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
