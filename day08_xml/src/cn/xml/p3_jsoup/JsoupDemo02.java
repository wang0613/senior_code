package cn.xml.p3_jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
/*
    1. Jsoup：工具类，可以解析html或xml文档，返回Document
			* parse​(File in, String charsetName)：解析xml或html文件的。
		    * parse​(String html)：解析xml或html字符串
			* parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
 */

public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {

        URL resource = JsoupDemo02.class.getClassLoader().getResource("student.xml");
        String path = resource.getPath();

        //1.使用指定的编码，解析xml，返回document对象
        //  Document document = Jsoup.parse(new File(path), "utf-8");

        //2.使用字符串形式,字符串就是xml或HTML的内容
       /* String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                "<students>\n" +
                "\n" +
                "    <student number=\"s000\">\n" +
                "        <name>tony</name>\n" +
                "        <age>8</age>\n" +
                "        <sex>男</sex>\n" +
                "    </student>\n" +
                "\n" +
                "    <student number=\"s001\">\n" +
                "        <name>jack</name>\n" +
                "        <age>8</age>\n" +
                "        <sex>男</sex>\n" +
                "    </student>\n" +
                "\n" +
                "</students>";
        Document document = Jsoup.parse(str); */

        //3.通过通过网络路径获取
        URL url = new URL("http://www.baidu.com");//代表网络中的资源路径,获取网站的html文档
        Document document = Jsoup.parse(url, 10000);

        //直接打印dom树是字符串表现形式

        System.out.println("document = " + document);

    }
}
