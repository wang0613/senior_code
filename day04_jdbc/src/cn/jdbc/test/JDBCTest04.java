package cn.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用SQL语句创建一张表 DDL
 */
public class JDBCTest04 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement state = null;
        try {
            //1.获取执行驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            //3.获取执行对象
            state = conn.createStatement();

            String sql = "create table student (id int,name varchar(20))"; //创建表student

            int line = state.executeUpdate(sql);//返回结果为0

            System.out.println(line); //执行的是DDL语句是没有返回结果的，执行DML语句才有返回结果
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
