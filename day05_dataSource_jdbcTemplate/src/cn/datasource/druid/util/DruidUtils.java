package cn.datasource.druid.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 1. 定义一个类 JDBCUtils
 * 2. 提供静态代码块加载配置文件，初始化连接池对象
 * 3. 提供方法
 * 1. 获取连接方法：通过数据库连接池获取连接
 * 2. 释放资源
 * 3. 获取连接池的方法
 */
public class DruidUtils {

    //数据库连接池对象
    private static DataSource ds;

    static {

        try {
            //1.加载配置文件
            Properties prop = new Properties();
            prop.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            //2.获取DataSource数据库连接池对象
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //获取连接池方法
    public static DataSource getDs() {
        return ds;
    }
    //释放资源
    public static void close(Statement s, Connection conn) {
        if (s != null) {
            try {
                s.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement s, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        close(s,conn);
    }


}
