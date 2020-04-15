package cn.ssm.suyuesheng.Dao;

import cn.ssm.suyuesheng.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(int id);

    boolean insertUser(User user);

    boolean update(User user);

    boolean remove(int id);
}
