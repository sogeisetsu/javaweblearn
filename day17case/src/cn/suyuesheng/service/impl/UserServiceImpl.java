package cn.suyuesheng.service.impl;

import cn.suyuesheng.dao.impl.UserDaoImpl;
import cn.suyuesheng.domain.User;
import cn.suyuesheng.service.IUserService;
import cn.suyuesheng.util.DataBaseConnection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private JdbcTemplate template = DataBaseConnection.getTemplate();
    @Override
    public List<User> findAll() throws Exception {
        List<User> users = new UserDaoImpl(template).findALL();
        return users;
    }
}
