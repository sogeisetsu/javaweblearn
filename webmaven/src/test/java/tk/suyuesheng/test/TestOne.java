package tk.suyuesheng.test;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import tk.suyuesheng.dao.impl.UserDaoImpl;
import tk.suyuesheng.domain.User;
import tk.suyuesheng.util.DataBaseConnection;
import tk.suyuesheng.util.fectory.DomainFectory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestOne {
    public static void main(String[] args) {
        System.out.println("hello");
    }
    @Test
    public void testO(){
        JdbcTemplate template = DataBaseConnection.getTemplate();
    }
    @Test
    public void testDao(){
        JdbcTemplate template = DataBaseConnection.getTemplate();
        List<User> all = null;
        try {
           all = new UserDaoImpl(template).findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (User user : all) {
            System.out.println(user);
        }
    }
    @Test
    public void testService(){
        List<User> users = null;
        try {
            users = DomainFectory.getUserService().findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (User user : users) {
            System.out.println(user.getName());
        }

    }
    @Test
    public void testmap(){
        Map<String,String> mm =new HashMap<String, String>();
        mm.put("name", "ss");
        mm.put("age","15");
        for(Map.Entry<String,String> m : mm.entrySet()){
            System.out.println(m);
        }
    }
}
