package cn.datasource.druid.demo;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {

        //1.导入jar包  druid-1.0.9.jar

        //2. 定义配置文件：
        // 是properties形式的
        Properties prop = new Properties();

        //3. 加载配置文件。Properties
        //通过类加载器来直接  获取资源输出流
        InputStream input = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(input);

        //4. 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
//        DataSource ds = DruidDataSourceFactory.createDataSource(prop);

        //或者通过新建DruidDataSource来设置
        DruidDataSource ds = new DruidDataSource();

        ds.setDriverClassName(prop.getProperty("driverClassName"));
        ds.setUrl(prop.getProperty("url"));
        ds.setUsername(prop.getProperty("username"));
        ds.setPassword(prop.getProperty("password"));

        //5. 获取连接：getConnection
        Connection conn = ds.getConnection();
        System.out.println("conn = " + conn);


    }
}
