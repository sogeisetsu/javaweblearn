package tk.suyuesheng.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import tk.suyuesheng.dao.impl.UserDaoImpl;
import tk.suyuesheng.domain.User;
import tk.suyuesheng.service.IUserService;
import tk.suyuesheng.util.DataBaseConnection;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private JdbcTemplate template = DataBaseConnection.getTemplate();
    @Override
    public List<User> findAll() throws Exception {
        return new UserDaoImpl(template).findAll();
    }
}
