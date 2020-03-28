package tk.suyuesheng.service;

import tk.suyuesheng.domain.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll() throws Exception;
}
