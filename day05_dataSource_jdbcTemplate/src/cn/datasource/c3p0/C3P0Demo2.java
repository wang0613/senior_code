package cn.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0演示
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
//        testConfig();
        testNameConfig();
    }

    //测试默认的配置
    private static void testConfig() throws SQLException {
        //1.获取dataSource 使用xml中默认的配置
        DataSource ds = new ComboPooledDataSource();

        /**
         * 通过循环 验证：maxPoolSize 最大连接数量10
         *     结论：10位最大连接数，11无法获取连接
         */
        for (int i = 1; i <= 11; i++) {
            //2.获取连接对象
            Connection conn = ds.getConnection();
            System.out.println(i + "···" + conn);

            if (i == 3) {
                conn.close(); //运行到第三个，归还连接到连接池中
            }
        }
    }

    //测试指定名称的配置文件
    private static void testNameConfig() throws SQLException {

        //获取dataSource 使用xml中指定名称的配置文件
        DataSource ds = new ComboPooledDataSource("otherc3p0");

        //默认8个最大连接
        for (int i = 1; i <= 8; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + "···" + conn);

            if (i == 3) {
                conn.close();
            }
        }
    }
}
