package suyuesheng.xinsheng.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlsessionUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream resourceAsStream = SqlsessionUtils.class.getResourceAsStream("/mybatis.config.xml");
        System.out.println("resourceAsStream = " + resourceAsStream);
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public static SqlSession getSqlsession(){
        return sqlSessionFactory.openSession(true);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
