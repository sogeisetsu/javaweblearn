package tk.suyuesheng.jedisstudy;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisStudyOne {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username", "soannn");
        String username = jedis.get("username");
        System.out.println(username);
//        jedis.close();
        jedis.del("username");
        jedis.hset("jj", "uu","susu");
        Map<String, String> jj = jedis.hgetAll("jj");
        for(Map.Entry<String,String> j: jj.entrySet()){
            System.out.println(j);
        }
        jedis.lpush("listl", "hahah");
        List<String> listl = jedis.lrange("listl", 0, -1);
        for (String s : listl) {
            System.out.println(s);
        }
        jedis.sadd("sadds", "hello","world");
        Set<String> sadds = jedis.smembers("sadds");
        for (String sadd : sadds) {
            System.out.println(sadd);
        }
        jedis.zadd("zaddz", 40, "hello");
        jedis.zadd("zaddz", 55, "hahah");
        Set<String> zaddz = jedis.zrange("zaddz", 0, -1);
        for (String s : zaddz) {
            System.out.println(s);
        }
        jedis.close();
    }
    @Test
    public void testPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        System.out.println("哈哈哈哈");
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        JedisPool pool = new JedisPool(config, "localhost", 6379);
        Jedis jedis = pool.getResource();
        jedis.lpush("liuliu", "123");
        jedis.close();
    }
}
