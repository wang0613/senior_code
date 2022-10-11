package cn.xml.p3_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 1. selector:选择器
 * ​		* 使用的方法：Elements	select​(String cssQuery)
 * ​				* 语法：参考Selector类中定义的语法
 * ​	2. XPath：XPath即为XML路径语言，它是一种用来确定XML（标准通用标记语言的子集）文档中某部分位置的语言
 * ​		* 使用Jsoup的Xpath需要额外导入jar包。
 * ​		* 查询w3cshool参考手册，使用xpath的语法完成查询
 */
public class JsoupDemo05 {
    public static void main(String[] args) throws IOException {

        //1.获取xml文件路径
        String path = JsoupDemo05.class.getClassLoader().
                getResource("student.xml").getPath();

        //2.获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
//        div{
//
//        }
        Elements name = document.select("name");
        System.out.println(name);
        System.out.println("________________________");

        //查询id值为itcast的元素
        /*          #id值{
                }
         */
//        Elements id = document.select("#wang");
//        System.out.println("id = " + id);
//        System.out.println("-------------------------");

        //案例： 获取student标签并且number属性值为s001
        Elements elements = document.select("student[number=\"s001\"]");

        //案例： 获取student标签并且number属性值为s001的age子标签
        Elements age = document.select("student[number=\"s001\"]>age");
        System.out.println(age);
    }
}
