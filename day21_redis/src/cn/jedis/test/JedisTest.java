package cn.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {


    /**
     * 操作String类型
     * set/get del
     */
    @Test
    public void test1() {
        //1.获取连接
        Jedis jedis = new Jedis("127.0.0.1", 6379); //指定主机名,端口
        //注意：如果不传入参数，默认为localhost 端口6379

        //2.存储操作
        jedis.set("username", "lisi");

        //获取
        String username = jedis.get("username");
        System.out.println("username = " + username);

        //可以使用setex()方法存储 可以指定过期时间的key value
        jedis.setex("code", 20, "guoqile!!");
        //将key：code value：guoqile存储redis并且20秒后自动删除该键值对


        //3.释放资源
        jedis.close();
    }

    /**
     * 操作哈希类型
     * hset/hget/hgetAll/hdel
     */
    @Test
    public void test2() {
        Jedis jedis = new Jedis();

        //设置哈希hash
        jedis.hset("user", "username", "wang");
        jedis.hset("user", "age", "20");
        jedis.hset("user", "gender", "男");

//        String username = jedis.hget("user", "username");//获取
//        String age = jedis.hget("user", "age");
//        String gender = jedis.hget("user", "gender");

//        System.out.println("username = " + username + ",age:" + age + ",gender:" + gender);


        //获取全部
        Map<String, String> user = jedis.hgetAll("user");
        Iterator<String> iterator = user.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = user.get(key);

            System.out.println(key + ":" + value);

        }


        jedis.close();
    }

    /**
     * 操作list类型
     * lpush/rpush
     * lrange
     * lpop/rpop
     */
    @Test
    public void test3() {
        Jedis jedis = new Jedis();

        jedis.lpush("zimu", "a", "b", "c"); //从左边
        jedis.rpush("zimu", "a", "b", "c"); //从右边


        //从左边获取
        String s1 = jedis.lpop("zimu");
        System.out.println(s1);

        //从左边获取
        String end = jedis.rpop("zimu");
        System.out.println("end = " + end);

        System.out.println("------------------------");
        //范围获取
        List<String> zimu = jedis.lrange("zimu", 0, -1);
        for (String s : zimu) {
            System.out.println(s);
        }

        jedis.close();
    }


    /**
     * 操作set集合：不允许重复元素
     * sadd/smembers/srem
     */
    @Test
    public void test4() {
        Jedis jedis = new Jedis();

        jedis.sadd("myset", "java", "php", "c++");

        Set<String> myset = jedis.smembers("myset");
        for (String s : myset) {
            System.out.println(s); //保证唯一
        }

        jedis.close();
    }


    /**
     * 操作set集合：不允许重复元素
     * zadd/zrange/zrem
     */
    @Test
    public void test5() {
        Jedis jedis = new Jedis();

        //根据分数排序
        jedis.zadd("mysort", 50,"Java");
        jedis.zadd("mysort", 40,"php");
        jedis.zadd("mysort", 30,"Python");

        //获取(不包括分数)
        Set<String> mysort = jedis.zrange("mysort", 0, -1);
        for (String s : mysort) {
            System.out.println(s);
        }


        //获取包括分数
        Set<Tuple> mysort1 = jedis.zrangeWithScores("mysort", 0, -1);
        for (Tuple tuple : mysort1) {
            double score = tuple.getScore(); //score
            String element = tuple.getElement(); //member

        }

        jedis.close();

    }


}




