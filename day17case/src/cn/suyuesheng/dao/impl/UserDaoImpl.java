package cn.suyuesheng.dao.impl;

import cn.suyuesheng.dao.IUserDao;
import cn.suyuesheng.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * IUserDao 的实现类
 * @author 苏月晟
 */
public class UserDaoImpl implements IUserDao {
    private JdbcTemplate template;
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.template=jdbcTemplate;
    }
    @Override
    public List<User> findALL() throws Exception {
        String sql = "SELECT * FROM user";
        List<User> userList=template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }
}
