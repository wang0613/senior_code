package cn.xml.p3_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup快速入门
 * 1. 导入jar包
 * 2. 获取Document对象
 * 3. 获取对应的标签Element对象
 * 4. 获取数据
 */

public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        //2.获取document对象，通过student.xml文档获取
        //2.1 获取student,xml的文件路径,通过类加载器获取统一资源定位符URL，在获取path
        URL resource = JsoupDemo01.class.getClassLoader().getResource("student.xml");
        String path = resource.getPath();

        //3.解析xml文档，加载文档进入内存，然后获取DOM树，document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //4.获取元素对象,获取name，name对应的是element标签对象,
        // 通过标签名获取,因为不止一个，返回多个元素对象,相当于ArrayList<Elements>看待
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size()); //2个 元素对象的个数是2个

        //获取第一个name的element对象，通过get方法获取索引0的对象
        Element element = elements.get(0);
        //获取文本数据
        String name = element.text();
        System.out.println("name = " + name);


    }
}
