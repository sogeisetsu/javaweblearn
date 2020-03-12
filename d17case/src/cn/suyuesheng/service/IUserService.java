package cn.suyuesheng.service;

import cn.suyuesheng.domain.User;

import java.util.List;

/**
 * 业务逻辑层接口
 */
public interface IUserService {
    public List<User> findAll() throws Exception;

    /**
     * 在登陆时检查账户和密码是否和数据库里面的内容相匹配
     * @param user User类
     * @return 如果匹配就返回True，反之False
     * @throws Exception
     */
    public Boolean login(User user) throws Exception;

    /**
     * 获取loginUser
     * @param user
     * @return User类 否则返回null
     * @throws Exception
     */
    public User getLogin(User user) throws Exception;
}
