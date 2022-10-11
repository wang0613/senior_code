package cn.xml.p3_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/*
document对象功能:
     1.获取子标签对象
			* getElementById​(String id)：根据id属性值获取唯一的element对象
			* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
			* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
			* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
	 2. 获取属性值
		* String attr(String key)：根据属性名称获取属性值
	 3. 获取文本内容
		* String text():获取包括子标签的纯文本内容
		* String html():获取包括子标签的字符串表现形式
 */

public class JsoupDemo04 {
    public static void main(String[] args) throws IOException {

        //获取xml文件的路径
        String path = JsoupDemo04.class.getClassLoader().
                getResource("student.xml").getPath();

        //2.根据xml的path获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.获取所有的student对象,中的第一个
        Element element = document.getElementsByTag("student").get(0);
        //获取student中的子标签对象
        Elements name = element.getElementsByTag("name");
        System.out.println(name.size()); //student子标签name只有一个

        System.out.println("----------------");
        //获取student的属性值:根据属性名number来获取值
        String number = element.attr("number");
        System.out.println(number);

        String text = name.text(); //text：获取name中的文本内容
        System.out.println(text);
        String html = name.html();//HTML：获取包括子元素内容字符串形式
        System.out.println(html);

    }
}
