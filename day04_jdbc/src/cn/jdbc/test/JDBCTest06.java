package cn.jdbc.test;

import cn.jdbc.bean.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询练习：
 * 查询db3 下的emp表数据，将其封装为对象，然后打印
 * 1.定义一个类
 * 2.定义方法
 * 3.实现方法 select *from emp;
 */
public class JDBCTest06 {

    //查询所有emp对象
    public List<Emp> findAll() {

        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;

        ArrayList<Emp> al = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            //3.获取执行对象
            state = conn.createStatement();
            //4.定义SQL语句
            String sql = "select * from emp";
            //执行
            rs = state.executeQuery(sql);

            //6.遍历结果集，封装对象，装进集合
            Emp emp = null;
            al = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(1);
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bouns = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                //创建emp对象
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bouns);
                emp.setDept_id(dept_id);

                //添加进集合
                al.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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

        return al;
    }

    public static void main(String[] args) {

        List<Emp> list = new JDBCTest06().findAll();

        System.out.println("list = " + list);
        System.out.println("list size = " + list.size());
    }


}
