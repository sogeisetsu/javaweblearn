package jedis.suyueshneg.dao.impl;

import jedis.suyueshneg.dao.IProvinceDao;
import jedis.suyueshneg.domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceImpl implements IProvinceDao {
    private JdbcTemplate template;
    public ProvinceImpl(JdbcTemplate template){
        this.template=template;
    }
    @Override
    public List<Province> findAll() throws Exception {
        String sql = "SELECT * FROM province";
        List<Province> provinces = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return provinces;
    }
}
