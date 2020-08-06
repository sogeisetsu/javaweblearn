package suyueshneg.xinsheng.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import suyuesheng.xinsheng.dao.UserMapper;
import suyuesheng.xinsheng.pojo.User;
import suyuesheng.xinsheng.utils.SqlsessionUtils;

import java.util.Date;
import java.util.List;

public class FTest {
    Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClass());
    @Test
    public void textOne(){
        System.out.println("开始");
    }
    @Test
    public void textSqlsessionUtil(){

        SqlSession sqlsession = SqlsessionUtils.getSqlsession();
        SqlSession sqlsession1 = SqlsessionUtils.getSqlsession();
        sqlsession1.close();

        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        mapper.findAll().forEach(System.out::println);
    }

    @Test
    public void insertTest(){
        SqlSession sqlsession = SqlsessionUtils.getSqlsession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        try {
            System.out.println("userMapper.insertUser(new User(12, \"劳力\",\"1232\")) = " + userMapper.insertUser(new User(120, "劳力", "1232")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try(SqlSession sqlsession = SqlsessionUtils.getSqlsession()){
            UserMapper mapper = sqlsession.getMapper(UserMapper.class);
            System.out.println("mapper.updateuser(new user(12, \"修改之后\",\"henhao\")) = " + mapper.updateUser(new User(12, "修改之后", "henhao")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById(){
        try(SqlSession sqlsession = SqlsessionUtils.getSqlsession()) {
            UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
            System.out.println("userMapper.findById(12) = " + userMapper.findById(12));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试时间
     */
    @Test
    public void testTime(){
        try(SqlSession sqlsession = SqlsessionUtils.getSqlsession();) {
            UserMapper mapper = sqlsession.getMapper(UserMapper.class);
            System.out.println("mapper.insertUser(new User(1345, \"测试时间\", \"123245\", new Date())) = " + mapper.insertUser(new User(13451, "测试时间", "123245", new Date())));
            System.out.println(mapper.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

    @Test
    public void testDelete(){
        try(SqlSession sqlsession = SqlsessionUtils.getSqlsession()){
            UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
            System.out.println("开始");
            userMapper.findAll().forEach(System.out::println);
            System.out.println("userMapper.deleteUser(new User(12)) = " + userMapper.deleteUser(new User(12)));
            System.out.println("结束");
            System.out.println("userMapper.findById(12) = " + userMapper.findById(12));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 侧式注解
     */
    @Test
    public void testDeleteAnn(){
        try(SqlSession sqlsession = SqlsessionUtils.getSqlsession()){
            UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
            System.out.println("userMapper.deleteById(1345) = " + userMapper.deleteById(1345));
            userMapper.findAll().forEach(System.out::println);
            logger.warn("haha");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 测试动态sql
     */
    @Test
    public void testDynamic(){
        try(SqlSession sqlSession = SqlsessionUtils.getSqlsession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println("userMapper.findByName(new User().getName()) = " + userMapper.findByName(new User().getName()));
        }
    }
}
