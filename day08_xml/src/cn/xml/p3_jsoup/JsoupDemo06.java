package cn.xml.p3_jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Xpath查询
 */
public class JsoupDemo06 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {

        //1.获取xml文件路径
        String path = JsoupDemo06.class.getClassLoader().
                getResource("student.xml").getPath();

        //2.获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.根据document创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        //4.结合Xpath语法查询
        //  //student表示查询所有的student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");

        for (JXNode jx : jxNodes) {
//            System.out.println(jx);
        }

        //需求: 查询student下的所有name标签 /表示子节点
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes1) {
//            System.out.println(jxNode);
        }

        //需求：查询student下带id属性的name标签  [@id]表示带有id属性
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }

        //需求：查询student下带id属性的name标签，并且id的属性值为001
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='001']");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }

    }
}
