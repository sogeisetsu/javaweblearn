package jedis.suyueshneg.util.fectory;

import jedis.suyueshneg.service.impl.ProvinceServiceImpl;

public class DomainFectory {
    public static ProvinceServiceImpl getProvinceService(){
        return new ProvinceServiceImpl();
    }
}
