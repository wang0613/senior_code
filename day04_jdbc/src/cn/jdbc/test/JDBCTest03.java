package cn.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * * 3. account表 删除一条记录
 */
public class JDBCTest03 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement state = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");

            String sql = "delete from account where id= 3"; //删除id为3的数据

            state = conn.createStatement();

            int line = state.executeUpdate(sql);
            System.out.println("受到影响的行数为：" + line);

            if (line > 0) {
                System.out.println("删除成功！！！");
            } else {
                System.out.println("删除失败！！");
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
