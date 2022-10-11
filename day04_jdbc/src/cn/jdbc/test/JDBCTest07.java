package cn.jdbc.test;

import cn.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc控制事务
 * 使用Connection管理事务
 * 开启事务：void  setAutoCommit(boolean autoCommit) 参数为false即为关闭自动提交，开启手动提交
 * 提交事务：void  commit();
 * 回滚事务  void  rollback();
 */
public class JDBCTest07 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            /**
             * 使用 jdbc完成转账案例
             */
            //1.获取连接
            conn = JDBCUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            //2.定义sql 两条
            String sql = "UPDATE account SET blance = blance-? WHERE id = ?";
            String sql2 = "UPDATE account SET blance = blance+? WHERE id = ?";

            //3.获取SQL执行对象
            ps1 = conn.prepareStatement(sql);
            ps2 = conn.prepareStatement(sql2);

            //3.设置参数
            ps1.setDouble(1,500);
            ps1.setInt(2,1);

            ps2.setDouble(1,500); //第二行SQL语句设置值
            ps2.setInt(2,2);

            //执行增删改使用 update方法
            ps1.executeUpdate();
            //手动制造异常
//            int i = 3/0;
            ps2.executeUpdate();

            //提交事务
            conn.commit();

        } catch (Exception e) { //抓大个异常，手动制造的异常，会进行回滚

            try {
                if (conn != null)
                //在catch里面事务回滚
                conn.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

            e.printStackTrace();
        } finally {

            JDBCUtils.close(ps1,conn);
            JDBCUtils.close(ps2,null);
        }
        //执行成功！！代码写的不好

    }
}
