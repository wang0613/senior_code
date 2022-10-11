package cn.Test;

import cn.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 需求：
 * 通过键盘录入用户名和密码
 * 判断用户输入是否正确
 * 分析：  使用查询语句判断表中是否有数据，查到就有数据，反之则没有
 */
public class Test {

    /**
     * 登录方法
     */
    public boolean login(String username, String password) {

        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement sm = null;
        ResultSet query = null;
        try {
            //获取连接对象
            conn = JDBCUtils.getConnection();
            //定义SQL
            String sql = "select * from user where username= '" + username + "'and password = '" + password + "'";
            //获取执行sql的对象
            sm = conn.createStatement();

            query = sm.executeQuery(sql); //执行sql返回结果集对象

            //判断 : 如果有下一行就返回true,没有就返回 false
            return query.next();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            JDBCUtils.selectClose(query, sm, conn);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String username = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();

        boolean falg = new Test().login(username, password);
        if (falg) {
            System.out.println("登录成功！！");
        } else  {
            System.out.println("登录失败！！");
        }

    }
}
