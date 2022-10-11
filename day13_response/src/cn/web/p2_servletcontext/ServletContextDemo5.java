package cn.web.p2_servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//ServletContext对象功能:
//获取文件的真实(服务器)路径
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取ServletContext对象
        ServletContext context = request.getServletContext();

        //获取文件服务器路径
        String realPath = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println("realPath = " + realPath);
        //D:\IdeaProjects\senior_code\out\artifacts\day13_response_war_exploded\b.txt

        // “/”相当于：D:\IdeaProjects\senior_code\out\artifacts\day13_response_war_exploded
        String s = context.getRealPath("/WEB-INF/c.txt"); //获取WEB-INF目录下资源

        context.getRealPath("/WEB-INF/classes/a.txt");//获取src下的文件路径

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
