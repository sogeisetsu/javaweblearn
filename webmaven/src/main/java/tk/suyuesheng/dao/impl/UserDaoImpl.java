package tk.suyuesheng.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tk.suyuesheng.dao.IUserDao;
import tk.suyuesheng.domain.User;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private JdbcTemplate template;
    public UserDaoImpl(JdbcTemplate template){
        this.template=template;
    }
    @Override
    public List<User> findAll() throws Exception {
        String sql = "SELECT * FROM user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
