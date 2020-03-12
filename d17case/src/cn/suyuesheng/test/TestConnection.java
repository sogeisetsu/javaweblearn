package cn.suyuesheng.test;

import cn.suyuesheng.dao.impl.UserDaoImpl;
import cn.suyuesheng.domain.User;
import cn.suyuesheng.service.impl.UserServiceImpl;
import cn.suyuesheng.util.DataBaseConnection;
import cn.suyuesheng.util.fectory.DomainFectory;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.AfterTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TestConnection {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream inputStream = TestConnection.class.getResourceAsStream("/druid.properties");
        DataSource dataSource = null;
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcTemplate template = new JdbcTemplate(dataSource);
        System.out.println(template);
        String url = "insert into user values(1,'张三','man',19,'北京','1446948579','1446984325@qq.com')";
        template.update(url);
    }

    @Test
    public void testUtils() {
        JdbcTemplate template = DataBaseConnection.getTemplate();

        String sql = "SELECT * From user";
        List<Map<String, Object>> list = template.queryForList(sql);
        list.forEach(System.out::println);
        System.out.println(template);
//        sql="INSERT INTO user VALUES(1,'张三','man',19,'北京','1446948579','1446984325@qq.com') ";
//
//        template.update(sql);
        sql = "SELECT * FROM user WHERE id=?";
        List<User> userList = null;
        userList = template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setGender(resultSet.getString("gender"));
                return user;
            }
        }, 1);
        System.out.println(userList);
        List<User> uu = template.query(sql, new BeanPropertyRowMapper<User>(User.class), 1);
        uu.forEach(System.out::println);
    }

    @Test
    public void testDao() {
        try {
            List<User> users = new UserServiceImpl().findAll();
            System.out.println(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<User> all = DomainFectory.getUserService().findAll();
            System.out.println(all);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findId() {
        Integer id = 9;
        JdbcTemplate template = DataBaseConnection.getTemplate();
        User byId = null;
        try {
            byId = new UserDaoImpl(template).findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(byId);
    }
    @Test
    public void checkLogin(){
        User user = new User();
        user.setId(12);
        user.setName("root");
        user.setPassword("15990904343");
        try {
            Boolean login = DomainFectory.getUserService().login(user);
            System.out.println(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}