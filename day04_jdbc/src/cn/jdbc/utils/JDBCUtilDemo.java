package cn.jdbc.utils;

import cn.jdbc.bean.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtilDemo {

    //jdbc工具类演示
    public List<Emp> findAll2() {

        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;

        ArrayList<Emp> al = null;

        try {
            //使用工具类获取连接对象
            conn = JDBCUtils.getConnection();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.selectClose(rs,state, conn);

        }
        return al;
    }

    public static void main(String[] args) {
        List<Emp> list = new JDBCUtilDemo().findAll2();

        System.out.println("list = " + list);
        System.out.println(list.size());



    }
}
