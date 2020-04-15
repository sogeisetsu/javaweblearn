package cn.ssm.suyuesheng.Dao;

import cn.ssm.suyuesheng.domain.User;
import cn.ssm.suyuesheng.utils.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void TestOne(){
        //方法一
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> users = mapper.findAll();
        System.out.println(users);
//        sqlSession.close();

        User user = mapper.findById(1);
        System.out.println(user);
        try {
            boolean lisa = mapper.insertUser(new User(6, "lisa", "12243557"));
            //不要忘记提交事务
            sqlSession.commit();
            System.out.println(lisa);
        } catch (Exception e) {
            System.out.println("插入失败");
        }
        mapper.findAll().forEach(System.out::println);
    }
    @Test
    public void TestTwo(){
        //方式二
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        List<User> list = sqlSession.selectList("cn.ssm.suyuesheng.Dao.UserDao.findAll");
        for (User user : list) {
            System.out.println(user);
        }
        User findById = (User) sqlSession.selectOne("findById", 1);
        System.out.println(findById);
    }

    /**
     * 验证增查删改
     */
    @Test
    public void TestCRUD(){
        //update
        SqlSession sqlSession = SqlsessionUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findById(5);
        user.setName("老李");
        user.setPwd("hesu1244");
        boolean update = mapper.update(user);
        System.out.println(update);
        sqlSession.commit();
        mapper.findAll().forEach(System.out::println);
        //delete
        mapper.remove(1);
        sqlSession.commit();

    }
}
