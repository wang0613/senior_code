package cn.datasource.jdbctemplate;

import cn.datasource.druid.util.DruidUtils;
import cn.datasource.jdbctemplate.bean.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest01 {

    //1.获取数据源
    private final DataSource ds = DruidUtils.getDs();
    //2.获取template，传入数据源
    JdbcTemplate template = new JdbcTemplate(ds);


    //JUnit单元测试,可以让方法独立运行，不在依赖主方法
    /**
     * 需求：
     * 修改emp 表中的1号数据salary为10000
     */
    @Test
    public void test1() {
        //1.获取数据源
        DataSource ds = DruidUtils.getDs();
        //2.获取template，传入数据源
        JdbcTemplate template = new JdbcTemplate(ds);
        //3.定义SQL
        String sql = "update emp set salary= 10000 where id = ?";
        //4.设置值，并执行
        int line = template.update(sql, 1001);//1001 是问号的值
        System.out.println("受影响的行数是： = " + line);
    }

    /**
     * 2. 添加一条记录
     */
    @Test
    public void test2() {
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int line = template.update(sql, 1015, "旺财", 10); //3个问号的值，防止SQL注入问题
        System.out.println("line = " + line);

    }

    /**
     * 3. 删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from emp where id = ?";
        int line = template.update(sql, 1015);
        System.out.println("line = " + line);

    }

    /**
     * 4. 查询id为1001的记录，将其封装为Map集合
     * QueryForMap：注意查询的结果集长度只能为1,将列名作为键，值作为value，将这条记录封装map集合
     */
    @Test
    public void test4() {
        String sql = "select * from emp where id = ? ";
//        String sql = "select * from emp where id = ? or id = ?";

        //查询语句使用的是query   封装为map集合使用的是forMap 返回一个map集合
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println("map = " + map);
        //map = {id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
    }

    /**
     * 5. 查询所有记录，将其封装为List
     * queryForList():查询结果将结果集封装为list集合
     * 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
     */
    @Test
    public void test5() {
        String sql = "select * from emp";
        //返回的记录是一个map集合，再将map集合装到list集合里面
        List<Map<String, Object>> list = template.queryForList(sql);

        //list集合里面装的全是map集合
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println("stringObjectMap = " + stringObjectMap);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     * query():查询结果，将结果封装为JavaBean对象
     * 手动实现RowMapper接口
     */
    @Test
    public void test6() {
        String sql = "select * from emp";

        //使用接口，通过执行SQL获取结果集，通过结果集获取值，传入emp中
        List<Emp> empList = template.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();

                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                //获取到的值 设置给emp对象
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });
        for (Emp e : empList) {
            System.out.println(e);
        }
    }

    //使用接口实现类 简化代码
    //使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
    //传入指定类型的泛型，括号内传入 泛型的class文件
    @Test
    public void test7() {
        String sql = "select * from emp";

        List<Emp> empList = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));

        //这里有个错误就是 bonus是double类型的，因为没有传入值，是null，double不能为null，所以报错
        //解决办法: 搞成包装类
        for (Emp emp : empList) {
            System.out.println(emp);
        }

    }

    /**
     * 7. 查询总记录数
     * queryForObject：查询结果，将结果封装为对象,括号内传入要封装的类型class文件
     * * 一般用于聚合函数的查询
     */
    @Test
    public void test8() {
        String sql = "select count(id) from emp";

        Long total = template.queryForObject(sql, Long.class);
        System.out.println("total = " + total);  //14条 ok
    }

}
