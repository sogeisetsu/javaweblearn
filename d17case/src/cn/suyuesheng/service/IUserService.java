package cn.suyuesheng.service;

import cn.suyuesheng.domain.User;
import cn.suyuesheng.util.BeanPage;

import java.util.List;
import java.util.Map;

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

    /**
     * 增加一个user考虑是否已经存在的问题
     * @param user
     * @return 如果该user的name是已经存在的，就返回false；如果该user在添加过程中出现错误就返回false，如果添加成功就返回true
     * @throws Exception
     */
    public Boolean addUser(User user) throws Exception;
    public Boolean delete(Integer id) throws Exception;
    public User findById(Integer id) throws Exception;
    public Boolean update(User user) throws Exception;
    public Boolean deleteByIds(String[] ids) throws Exception;
    public BeanPage<User> findUserByPage(int currentPage, int rows, Map<String, String[]> map) throws Exception;
}
