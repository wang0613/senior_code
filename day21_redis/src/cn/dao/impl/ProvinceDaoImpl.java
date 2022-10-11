package cn.dao.impl;

import cn.dao.ProvinceDao;
import cn.domain.Province;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    //1.声明成员变量jdbsTemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //2.定义sql语句
        String SQL = "select * from province";
        //3.执行sql，返回list集合，包装类
        List<Province> list = template.query(SQL, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
