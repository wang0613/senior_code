package cn.datasource.druid.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilsTest {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //使用工具类,完成添加操作
            //1.获取连接
            conn = DruidUtils.getConnection();
            //2.定义sql
            String sql = "insert into account values(null,?,?)";
            //3.获取执行对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, "wang");
            ps.setDouble(2, 5000);

            int line = ps.executeUpdate();
            System.out.println("line = " + line);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            DruidUtils.close(ps, conn);
        }

    }
}
