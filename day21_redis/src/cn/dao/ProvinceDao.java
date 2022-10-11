package cn.dao;

import cn.domain.Province;

import java.util.List;

public interface ProvinceDao {

    /**
     * 查询所有的省份方法
     * @return
     */
     List<Province> findAll();
}
