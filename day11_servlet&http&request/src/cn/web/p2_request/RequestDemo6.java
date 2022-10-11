package cn.web.p2_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * 其他功能：获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
 * ​		1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
 * ​		2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
 * ​		3. Enumeration<String> getParameterNames():获取所有请求的参数名称（键）
 * ​		4. Map<String,String[]> getParameterMap():获取所有参数的map集合
 * ​
 */
@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.post获取请求参数 通过键获取值name
        String username = request.getParameter("username");
//        System.out.println("post");
//        System.out.println(username); //aaaa

        //2.根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby); //game study
        }
//        //3.获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(name + "····"+value);
        }
        //4.获取所有参数的map集合
        Map<String, String[]> map = request.getParameterMap();
        Iterator<String> it = map.keySet().iterator(); //获取键
        while (it.hasNext()) {
            String key =  it.next();
            String[] values = map.get(key); //通过键来获取全部的值

            for (String value : values) {

                System.out.println(key+"····"+value);
            }
            System.out.println("-------------------------");

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get获取请求
//        String username = request.getParameter("username");
//        System.out.println("get");
//        System.out.println(username);
        //这样代码就不用谢两份了 直接调用doPost();
        this.doPost(request,response);

    }
}
