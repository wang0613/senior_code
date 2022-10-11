package cn.jdbc.test;

import java.sql.*;

/**
 * 查询account表
 */
public class JDBCTest05 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;

        try {
            //1.获取执行驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            //3.获取执行对象
            state = conn.createStatement();
            //4.定义sql语句
            String sql = "select * from account"; //查询语句

            //5.执行查询语句需要使用   executeQuery();，返回一个结果集
             rs = state.executeQuery(sql);

             //6.拿到了结果集，处理解剖
            //rs.next();光标向下移动一行，true为当前行有效，false没有更多的行
            while (rs.next()) {
                int id = rs.getInt(1); //获取第一列的id
                String name = rs.getString("name"); //获取第二列name
                double blance = rs.getDouble("blance"); //获取第三列blance
                System.out.println(id + "···"+name +"···" + blance);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            if (rs !=null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
