package cn.jedis.test;

import cn.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池使用
 */
public class JedisConnectionPool {

    @Test
    public void test() {

        //0.创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50); //设置最大连接数
        config.setMaxIdle(10); //设置最大的空闲连接


        //1.创建连接池对象
        JedisPool pool = new JedisPool(config,"localhost",6379);

        //2.获取连接资源
        Jedis jedis = pool.getResource();

        jedis.set("username","zhangsna");

        //归还连接
        jedis.close();
    }

    /**
     * 测试连接池
     */
    @Test
    public void testUtil() {

        Jedis jedis = JedisPoolUtils.getJedis(); //通过工具类获取连接对象

        jedis.set("username","zhangsna");

        //归还连接
        jedis.close();
    }
}
