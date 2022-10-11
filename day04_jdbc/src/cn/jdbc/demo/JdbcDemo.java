package cn.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门：
 *
 */
public class JdbcDemo {


    public static void main(String[] args) throws Exception {

        //导入jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");//通过class对象加载进内存

        //3.获取数据库的连接对象  getConnection尝试建立与给定数据库URL的连接。
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");

        //4.定义SQL语句
        String sql= "update account set blance= 500 where id = 1"; //修改余额
        //5.通过数据库连接对象，获取SQL执行的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql); //执行修改sql语句

        //7.处理结果
        System.out.println(count);

        //8.释放资源
        stmt.close();
        conn.close();
    }
}
