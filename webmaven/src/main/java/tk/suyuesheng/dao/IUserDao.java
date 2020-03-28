package tk.suyuesheng.dao;

import tk.suyuesheng.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 返回所有的用户 list集合
     * @return  用户 list集合
     * @throws Exception
     */
    public List<User> findAll() throws Exception;
}
