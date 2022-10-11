package cn.Test;

import cn.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 使用preparedStatement解决sql注入问题
 */
//          1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
//			2. 注册驱动
//			3. 获取数据库连接对象 Connection
//			4. 定义sql
//			5. 获取执行sql语句的对象 PreparedStatement  Connection.prepareStatement(String sql)
//          6. 给？赋值： setXxx(参数1,参数2)
//			7. 执行sql，接受返回结果，不需要传递sql语句
//			8. 处理结果
//			9. 释放资源
public class Test01 {


    public boolean login(String username, String password) {

        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            conn = JDBCUtils.getConnection();

            String sql = "select * from user where username= ? and password = ?";

            //获取执行sql语句的对象 PreparedStatement
            ps = conn.prepareStatement(sql);

            ps.setString(1,username); //给第一个问号赋值
            ps.setString(2,password);

            rs = ps.executeQuery();//执行sql查询语句

            return rs.next();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            //prepareStatement是statement子类，无需重新设置关闭方法
            JDBCUtils.selectClose(rs,ps,conn);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String username = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();

        boolean falg = new Test01().login(username, password);
        if (falg) {
            System.out.println("登录成功！！");
        } else  {
            System.out.println("登录失败！！");
        }
    }


}
