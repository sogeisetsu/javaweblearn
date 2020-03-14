package cn.suyuesheng.dao.impl;

import cn.suyuesheng.dao.IUserDao;
import cn.suyuesheng.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * IUserDao 的实现类
 *
 * @author 苏月晟
 */
public class UserDaoImpl implements IUserDao {
    private JdbcTemplate template;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    @Override
    public List<User> findALL() throws Exception {
        String sql = "SELECT * FROM user";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public User findById(Integer id) throws Exception {
        String sql = "SELECT * FROM user WHERE ID=?";
        User user = null;
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
        if (update == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean check(User user) throws Exception {
        Integer id = user.getId();
        String sql = "SELECT COUNT(*) FROM user WHERE ID=?";
        Long count = template.queryForObject(sql, Long.class, id);
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean check(Integer id) throws Exception {
        String sql = "SELECT COUNT(*) FROM user WHERE ID=?";
        Long count = template.queryForObject(sql, Long.class, id);
        if (count == 0) {
            return false;
        } else {
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
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
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

    @Override
    public Boolean addUser(User user) throws Exception {
        String sql = "INSERT INTO USER(NAME,ADDRESS,GENDER,QQ,AGE,EMAIL) VALUES(?,?,?,?,?,?)";
        try {
            int i = template.update(sql, user.getName(), user.getAddress(), user.getGender(), user.getQq(), user.getAge(), user.getEmail());
            if (i == 0) {
                return false;
            } else {
                return true;
            }
        } catch (DataAccessException e) {
//            e.printStackTrace();//should delete here
            return false;
        }
    }

    @Override
    public User findByName(String name) throws Exception {
        String sql = "SELECT * FROM USER WHERE NAME =?";
        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name);
            return user;
        } catch (DataAccessException e) {
//            e.printStackTrace();//should delete here
            return null;
        }
    }

    @Override
    public Boolean deleteById(Integer id) throws Exception {
        String sql = "DELETE FROM USER WHERE ID =?";
        int update = 0;
        try {
            update = template.update(sql, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        if (update == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int totalCount(Map<String, String[]> map) throws Exception {
        Set<String> keySet = map.keySet();
        StringBuffer stringBuffer = new StringBuffer("SELECT COUNT(*) FROM USER WHERE 1=1");
        List<Object> objects = new ArrayList<Object>();
        for(String key:keySet){
            if (key!=null && !"".equals(key) ) {
                if("currentPage".equals(key) || "rows".equals(key)){
                    continue;
                }
                if (map.get(key)[0]!=null && !"".equals(map.get(key)[0])) {
                    stringBuffer.append(" AND "+key+" LIKE "+" \'%"+map.get(key)[0].trim()+"%\' ");
                    objects.add(" %"+map.get(key)[0]+"% ");
                }
            }
        }
        System.out.println(stringBuffer.toString());
        Long aLong = template.queryForObject(stringBuffer.toString(), Long.class);
        int i = aLong.intValue();
        System.out.println(i);
        return i;
    }

    @Override
    public List<User> findByPage(int start, int end, Map<String, String[]> map) throws Exception {
        Set<String> keySet = map.keySet();
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM USER WHERE 1=1");
        List<Object> objects = new ArrayList<Object>();
        for(String key:keySet){
            if (key!=null&&!"".equals(key)) {
                if("currentPage".equals(key) || "rows".equals(key)){
                    continue;
                }
                if (map.get(key)[0]!=null && !"".equals(map.get(key)[0])) {
                    stringBuffer.append(" AND "+key+" LIKE "+" \'%"+map.get(key)[0].trim()+"%\' ");
                }
            }
        }
        stringBuffer.append(" LIMIT ?,? ");
        System.out.println(stringBuffer.toString());
        List<User> query = template.query(stringBuffer.toString(), new BeanPropertyRowMapper<User>(User.class), start,end);
        return query;
    }


}
