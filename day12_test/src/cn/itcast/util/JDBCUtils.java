package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC的工具类，使用的Druid连接池
 */
public class JDBCUtils {

    private static DataSource ds;

    static  {
        try {
            //1.加载配置文件
            Properties prop  =  new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(is);

            //2.初始化连接池
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    //1.获取连接池对象
    public static DataSource getDataSource() {
        return ds;
    }

    //2.获取连接connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
