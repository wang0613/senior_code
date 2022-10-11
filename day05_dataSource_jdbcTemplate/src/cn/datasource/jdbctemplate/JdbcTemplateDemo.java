package cn.datasource.jdbctemplate;

import cn.datasource.druid.util.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 1. 导入jar包
 * 	2. 创建JdbcTemplate对象。依赖于数据源DataSource
 * 		* JdbcTemplate template = new JdbcTemplate(ds);
 *
 * 	3. 调用JdbcTemplate的方法来完成CRUD的操作
 * 		* update():执行DML语句。增、删、改语句
 * 		* queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
 * 		       注意：这个方法查询的结果集长度只能是1
 * 		* queryForList():查询结果将结果集封装为list集合
 * 			  注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
 * 		* query():查询结果，将结果封装为JavaBean对象
 * 			* query的参数：RowMapper
 * 				* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
 * 				* new BeanPropertyRowMapper<类型>(类型.class)
 * 		* queryForObject：查询结果，将结果封装为对象
 * 			* 一般用于聚合函数的查询
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {

        //入门演示
        DataSource ds = DruidUtils.getDs();
        //2.创建JDBCTemplate对象,需要数据源

        JdbcTemplate template = new JdbcTemplate(ds);

        //3.调用方法
        String sql = "update account set blance = 500 where id = ?";

        int count = template.update(sql, 3);//3 表示第一个参数问号？
        System.out.println(count);

        //不需要释放资源，会自动帮你搞定

    }
}
