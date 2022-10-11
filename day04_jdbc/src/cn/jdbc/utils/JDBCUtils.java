package cn.jdbc.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类:
 * 尽量使用静态方法，方便使用
 */
public class JDBCUtils {

    public static String url;
    public static String user;
    public static String password;
    public static String driver;


    /**
     * 文件的读取，只读取一次即可拿到这些值，使用静态代码块执行
     */
    static {
        try {
            //读取资源文件
            Properties prop = new Properties();

            //获取src路径下的方式， 使用classLoader类加载器，可以将字节码文件加载进内存
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            System.out.println("path = " + path);

            prop.load(new FileReader(path));
            //把集合中的值传递给变量
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");

            Class.forName(driver);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接对象
    //	* 需求：不想传递参数（麻烦），还得保证工具类的通用性。
    //	* 解决：配置文件
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }

    //关闭资源 1.statement connection 增删改操作
    public static void close(Statement state, Connection conn) {

        if (state != null) {
            try {
                state.close();
            } catch (Exception e) {
                e.printStackTrace();
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

    //关闭资源  查询语句
    public static void selectClose(ResultSet result,Statement state, Connection conn ) {

        if (result != null) {
            try {
                result.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (state != null) {
            try {
                state.close();
            } catch (Exception e) {
                e.printStackTrace();
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
}
