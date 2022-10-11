package cn.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 练习：
 * 1. account表 添加一条记录
 */
public class JDBCTest01 {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql:///db3";
    static final String USER = "root";
    static final String PASSWORD = "root";


    public static void main(String[] args) {

        Connection conn = null; //声明连接对象为null
        Statement state = null; //声明执行对象为null

        try {
            //1.注册驱动
            Class.forName(JDBC_DRIVER);

            //2.定义sql
            String sql = "insert into account values(null,'wang',500)";

            //3.获取连接对象
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            //4.通过连接获取执行对象
            state = conn.createStatement();

            //5.执行sql
            int line = state.executeUpdate(sql);
            System.out.println("影响的行数为： = " + line);

            if (line > 0) {
                System.out.println("添加成功！！");
            } else {
                System.out.println("添加失败！！");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //为了避免未执行到state，出现异常，为了避免空指针异常，判断是否为空
            try {
                if (state != null)  state.close(); //释放资源时，优先释放state，

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn != null)  conn.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }
}
