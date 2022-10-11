package cn.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int height = 50;

        //1.创建一对象，代表验证码图片对象 高，宽和图片类型是GRB
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.createGraphics(); //通过验证码对象，创建画笔对象
        g.setColor(Color.PINK); //设置颜色
        g.fillRect(0, 0, width, height); //填充

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIJLMNOPQRSTUVWXYZabcdefghijlmnopqrstuvwxyz0123456789";

        Random r = new Random();
        //生成的字符 存放到容器中
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 4; i++) {
            int index = r.nextInt(str.length()); //生成随机角标
            //获取字符
            char ch = str.charAt(index);
            sb.append(ch);
            //2.3写验证码
            g.drawString(ch + "", width / 5 * i, height / 2);

        }
        String checkCode_session = sb.toString();//验证码
        //重要：将验证码存放到session中，等待获取比对
        request.getSession().setAttribute("checkCode_session", checkCode_session);

        //2.4设置干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 5; i++) {
            //随机生成坐标点
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        //3.将图片输出到页面展示，字节数出流
        //将图片对象，输出到 response的输出流中（浏览器）
        ImageIO.write(image, "jpg", response.getOutputStream());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
