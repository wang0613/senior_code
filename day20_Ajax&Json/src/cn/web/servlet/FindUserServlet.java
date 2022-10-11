package cn.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名
        String username = request.getParameter("username");

        response.setContentType("text/html;charset=utf-8");

        HashMap<String,Object> map = new HashMap<>();


        //2.调用service层判断用户是否存在
        if ("tom".equals(username)) {
            //响应数据
            map.put("userExist",true);
            map.put("msg","此用户名太受欢迎，请更换一个");
        }else {
            map.put("userExist",false);
            map.put("msg","此用户名太可用！");
        }
        //将map转换为json对象，并且传递给客户端
        ObjectMapper mapper = new ObjectMapper();

        //输出到指定的 输出流位置 这里是输出到客户端
        mapper.writeValue(response.getWriter(),map);
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
