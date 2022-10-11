package cn.test;

import cn.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * * JSON解析器：
 * * 常见的解析器：Jsonlib，Gson，fastjson，jackson
 * 这里使用jackson，spring内置的转换对象
 */
public class JacksonTest {

    //Java对象转化 JSON
    @Test
    public void test01() throws IOException {

        //1.创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(30);
        p.setGender("男");

        //2.创建JSON的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //3.调用方法记性转换
        /** 转换方法:
         *      writeValue(参数一，obj)；
         *        参数一：FIle ：将obj对象，转化为JSON字符串，并保存到执行的文件中
         *               Writer：将obj对象，转化为JSON字符串，并将JSON数据填充到字符输出流中
         *               OutputStream：将obj对象，转化为JSON字符串，并将JSON数据填充到字节输出流中
         *      writeValueAsString(obj); //将obj对象转换为JSON字符串
         */
        String json = mapper.writeValueAsString(p);
        //json = {"name":"张三","age":30,"gender":"男"}
        System.out.println("json = " + json); //JSON对象的字符串表现形式

        //将对象写入到具体的路径下
        mapper.writeValue(new File("d://a.txt"), p); //弄到具体的路径下

        mapper.writeValue(new FileWriter("d://b.txt"), p);
    }

    //Jackson注解的使用
    @Test
    public void test02() throws IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(30);
        p.setGender("男");
        p.setBirthday(new Date());

        //2.转换
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(p);
        //打印的生日为毫秒值
        //在birthday上添加注解 格式化
        System.out.println("json = " + json);
    }

    //复杂Java对象的转换JSON  LIST集合
    @Test
    public void test03() throws IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(30);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("lisi");
        p1.setAge(30);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(30);
        p2.setGender("男");
        p2.setBirthday(new Date());


        //创建List集合存储对象
        List<Person> list = new ArrayList<Person>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        //2.转换
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(list);
//json = [{"name":"张三","age":30,"gender":"男","birthday":"2020-06-24"},{"name":"lisi","age":30,"gender":"男","birthday":"2020-06-24"},{"name":"张三","age":30,"gender":"男","birthday":"2020-06-24"}]
        System.out.println("json = " + json);

    }

    //MAP集合
    @Test
    public void test04() throws IOException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(30);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("lisi");
        p1.setAge(30);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(30);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Map<String, Person> map = new HashMap<>();

        //2.转换
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(map);
        System.out.println("json = " + json);

    }


    //JSON转为Java对象
    @Test
    public void test05() throws IOException {
        String json = "{\"name\":\"张三\",\"age\":30,\"gender\":\"男\"}";

        //2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();

        Person person = mapper.readValue(json, Person.class);
        System.out.println("person = " + person);

    }


}
