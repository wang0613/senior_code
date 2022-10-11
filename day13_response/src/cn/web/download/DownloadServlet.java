package cn.web.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取请求参数,文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流记载文件进入内存
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename); //返回服务器路径
        //3.字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        String mimeType = context.getMimeType(filename); //获取文件的MIME类型
        //设置response的响应头，将视频以附件形式打开
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename="+filename);

        //4.将输出流的数据写出到response输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            sos.write(bytes,0,len);
        }
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
