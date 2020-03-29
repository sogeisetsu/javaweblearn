package jedis.suyueshneg.dao;

import jedis.suyueshneg.domain.Province;

import java.util.List;

public interface IProvinceDao {
    /**
     * 获得全部province
     * @return
     * @throws Exception
     */
    public List<Province> findAll() throws Exception;
}
