package cn.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jedis连接池工具类
 * 加载配置文件，配置连接池的参数
 * 提供获取连接池的方法
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    //使用静态代码块加载配置文件
    static {
        //使用类加载器加载
        InputStream is = JedisPoolUtils.class.getClassLoader().
                getResourceAsStream("jedis.properties");

        //创建properties集合
        Properties prop = new Properties();
        try {
            prop.load(is); //从流中加载
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPoolConfig
        JedisPoolConfig config = new JedisPoolConfig();

        //prop键值对都是String类型的，使用包装类进行转换
        config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));

        //初始化JedisPool对象
        jedisPool = new JedisPool(config, prop.getProperty("host"),
                Integer.parseInt(prop.getProperty("port")));

    }


    /**
     * 获取连接的方法
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}
