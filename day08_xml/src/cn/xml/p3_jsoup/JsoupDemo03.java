package cn.xml.p3_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/*
2. Document：文档对象。代表内存中的dom树
	* 获取Element对象
		* getElementById​(String id)：根据id属性值获取唯一的element对象
		* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
		* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合(id)
		* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
Elements：
        元素Element对象的集合。可以当做 ArrayList<Element>来使用
 */

public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {

        String path = JsoupDemo03.class.getClassLoader().
                getResource("student.xml").getPath();

        //2.根据xml的path获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.需求：获取所有的student对象
        Elements student = document.getElementsByTag("student");
        System.out.println(student);
        System.out.println("------------------------------------------");

        //3.获取属性名获取 attribute属性为id的
        Elements id = document.getElementsByAttribute("id");
        System.out.println(id.size());
        System.out.println("----------------------------------------");

        //4.获取number值为s000的对象
        Elements number = document.getElementsByAttributeValue("number", "s000");
        System.out.println("number = " + number);
    }
}
