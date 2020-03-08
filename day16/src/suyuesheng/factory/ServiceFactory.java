package suyuesheng.factory;

import suyuesheng.dbcserverce.IUserService;
import suyuesheng.dbcserverce.impl.UserServiceImpl;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 工厂类，获取业务层层接口的实例对象
 */
public class ServiceFactory {
    /**
     * 获取User表的业务层的实例化对象
     * @param template
     * @return
     */
    public static IUserService getUserServiceInstance(JdbcTemplate template){
        return new UserServiceImpl(template);
    }
}
