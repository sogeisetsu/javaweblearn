package cn.suyuesheng.dao;

import cn.suyuesheng.domain.User;

import java.util.List;

/**
 * 数据访问层接口
 * @author 苏月晟
 */
public interface IUserDao {
    /**
     * 查询操作，查询所有的User的全部信息，并将每一个用户信息封装在各自User类上，返回User类的List
     * @return 如果由用户就返回List 如果没有用户就返回List的集合长度为0
     */
    public List<User> findALL() throws Exception;
}
