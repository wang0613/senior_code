package cn.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * * 2. account表 修改记录
 */
public class JDBCTest02 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");

            //3.定义SQL语句
            String sql = "update account set blance = 2000 where id = 3 "; //修改零钱为2000
            //4.通过连接对象获取执行对象
            state = conn.createStatement();


            //执行sql
            int line = state.executeUpdate(sql);
            System.out.println("受到影响的行数为：" + line);

            if (line > 0) {
                System.out.println("执行成功！！！");
            } else {
                System.out.println("执行失败！！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }


    }
}
