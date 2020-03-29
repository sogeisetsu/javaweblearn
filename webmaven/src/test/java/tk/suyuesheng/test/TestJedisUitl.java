package tk.suyuesheng.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import tk.suyuesheng.util.JedisUtil;

import java.util.List;

public class TestJedisUitl {
    @Test
    public void testOne(){
        Jedis jedis = JedisUtil.getJedis();
        jedis.del("liuliu");
        jedis.lpush("list1", "hrhrhr");
        List<String> list1 = jedis.lrange("list1", 0, -1);
        System.out.println(list1.size());
        for (String s : list1) {
            System.out.println(s);
        }
        //归还连接
        jedis.close();
    }
}
