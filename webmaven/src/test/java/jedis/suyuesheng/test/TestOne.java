package jedis.suyuesheng.test;

import jedis.suyueshneg.domain.Province;
import jedis.suyueshneg.util.JedisUtil;
import jedis.suyueshneg.util.fectory.DomainFectory;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class TestOne {
    @Test
    public void testCon(){
        List<Province> all = null;
        try {
         all = DomainFectory.getProvinceService().findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Province province : all) {
            System.out.println(province);
        }
    }
    @Test
    public void testjedis(){
        Jedis jedis = JedisUtil.getJedis();
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
