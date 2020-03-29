package jedis.suyueshneg.service;

import jedis.suyueshneg.domain.Province;

import java.util.List;

public interface IProvinceService {

    /**
     * 获得全部province
     * @return
     * @throws Exception
     */
    public List<Province> findAll() throws Exception;

    public String findAllJson() throws Exception;
}
