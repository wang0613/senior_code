package cn.service.impl;

import cn.dao.ProvinceDao;
import cn.dao.impl.ProvinceDaoImpl;
import cn.domain.Province;
import cn.jedis.util.JedisPoolUtils;
import cn.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl  implements ProvinceService {
    //声明调用dao层
    ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        //调用dao层的方法
        return dao.findAll();
    }

    /**
     * 去使用redis缓存
     * @return
     */
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        Jedis jedis = JedisPoolUtils.getJedis(); //使用工具类
        String j_province = jedis.get("province");

        //2.判断有无数据
        if (j_province == null || j_province.length()==0){
            System.out.println("没有数据");

            //缓存中没有数据，从数据库中查询
            List<Province> ps = dao.findAll();
            //2.将list集合序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                j_province = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3将数据存储到缓存中redis
            jedis.set("province", j_province);

            //归还连接
            jedis.close();
        }else {
            //从缓存中查询
            System.out.println("有数据");
        }

        return j_province;
    }
}
