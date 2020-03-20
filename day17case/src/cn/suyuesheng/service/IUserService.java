package cn.suyuesheng.service;

import cn.suyuesheng.domain.User;

import java.util.List;

/**
 * 业务逻辑层接口
 */
public interface IUserService {
    public List<User> findAll() throws Exception;
}
