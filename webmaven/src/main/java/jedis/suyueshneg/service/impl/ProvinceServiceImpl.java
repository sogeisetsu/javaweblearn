package jedis.suyueshneg.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jedis.suyueshneg.dao.impl.ProvinceImpl;
import jedis.suyueshneg.domain.Province;
import jedis.suyueshneg.service.IProvinceService;
import jedis.suyueshneg.util.DatabaseConnection;
import jedis.suyueshneg.util.JedisUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements IProvinceService {
    private JdbcTemplate template = DatabaseConnection.getJdbcTemplate();
    @Override
    public List<Province> findAll() throws Exception {
        List<Province> all = new ProvinceImpl(template).findAll();
        return all;
    }

    @Override
    public String findAllJson() throws Exception {

        Jedis jedis = JedisUtil.getJedis();
////        jedis.set("province", s);
        if(jedis.get("province")==null||jedis.get("province").length()==0){
            System.out.println("第一次，从数据库写入缓存");
            List<Province> all = new ProvinceImpl(template).findAll();
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(all);
            jedis.set("province", s);
            return jedis.get("province");
        }else {
            System.out.println("从缓存中读");
            String province = jedis.get("province");
            return province;
        }

    }
}
