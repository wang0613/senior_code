package cn.web.servlet;

import cn.service.ProvinceService;
import cn.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1.调用service查询
//        ProvinceService service = new ProvinceServiceImpl();
//        List<Province> provinceList = service.findAll();
//
//        //2.序列化list 为json Java转换为json对象
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(provinceList);
//
//        System.out.println(json);
        //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}


        //使用缓存技术
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();
        System.out.println("json = " + json);
        //3.响应结果
        response.setContentType("application/json;charset=utf-8"); //指定响应类型


        response.getWriter().write(json); //写出json
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
