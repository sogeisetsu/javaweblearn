package cn.suyuesheng.dao.impl;

import cn.suyuesheng.dao.IUserDao;
import cn.suyuesheng.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public User findById(Integer id) throws Exception {
        String sql="SELECT * FROM user WHERE ID=?";
        User user= null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Boolean update(User user) throws Exception {
        Integer id = user.getId();
        String sql = "UPDATE user SET name=?,gender=?,address=?,qq=?,email=?,age=? WHERE id=?";
        int update = template.update(sql, user.getName(), user.getGender(), user.getAddress(), user.getQq(), user.getEmail(), user.getAge(), user.getId());
        if(update==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Boolean check(User user) throws Exception {
        Integer id = user.getId();
        String sql ="SELECT COUNT(*) FROM user WHERE ID=?";
        Long count = template.queryForObject(sql, Long.class, id);
        if(count==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Boolean check(Integer id) throws Exception {
        String sql ="SELECT COUNT(*) FROM user WHERE ID=?";
        Long count = template.queryForObject(sql, Long.class, id);
        if(count==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<User> findByAddress(String address) throws Exception {
        String sql = "SELECT * FROM user WHERE address=?";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), address);
        return users;
    }

    @Override
    public User findByNameAndFindByPassword(String name, String password) throws Exception {
        String sql = "SELECT * FROM user WHERE name=? AND password=?";
        try {
            User user = null;
//            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name,password);
//            System.out.println(user);
            return user;

        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findByNameAndFindByAddressAndFindByEmail(String name, String address, String email) throws Exception {
        return null;
    }


}
