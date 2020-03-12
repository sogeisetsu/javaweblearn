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

    @Override
    public Boolean login(User user) throws Exception {
        User login = new UserDaoImpl(template).findByNameAndFindByPassword(user.getName(), user.getPassword());
        if(login==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public User getLogin(User user) throws Exception {
        User loginUser = new UserDaoImpl(template).findByNameAndFindByPassword(user.getName(), user.getPassword());
        return loginUser;
    }
}
