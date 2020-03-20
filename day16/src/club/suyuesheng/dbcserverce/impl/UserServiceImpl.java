package club.suyuesheng.dbcserverce.impl;

import club.suyuesheng.vo.User;
import club.suyuesheng.dbcserverce.IUserService;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实现IUserService业务层接口
 */
public class UserServiceImpl implements IUserService {
    private JdbcTemplate template;
    public UserServiceImpl(JdbcTemplate template){
        this.template=template;
    }
    @Override
    public Boolean Query(User user) throws Exception {
        String sql = "SELECT count(*) from user WHERE name=? and password= ?";
        if(user!=null){
            Long x = template.queryForObject(sql, Long.class, user.getName(),user.getPassWord());
            if(x!=0){
                return true;
            }
        }
        return false;
    }

    @Override
    public User text(User loginUser) throws Exception {
        try {
            User ur=null;
            String sql = "SELECT * FROM user WHERE name=? AND password=? ";
            ur =template.queryForObject(sql, new RowMapper<User>() {

                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setName(resultSet.getString(1));
                    user.setPassWord(resultSet.getString(2));
                    return user;
                }
            }, loginUser.getName(),loginUser.getPassWord());
            return ur;
        } catch (DataAccessException e) {
            return null;
        }
    }

}
