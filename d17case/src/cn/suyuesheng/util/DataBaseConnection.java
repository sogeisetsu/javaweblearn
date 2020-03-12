package cn.suyuesheng.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 此类用来连接数据库，并提供JDBCtemplate和dataSourse
 * @author 苏月晟
 */
public class DataBaseConnection {
    private  static DataSource dataSource = null;
    private  static JdbcTemplate template = null;
    private static Connection connection =null;
    static {//实例化dataSourse
        Properties properties = new Properties();
        InputStream inputStream = DataBaseConnection.class.getResourceAsStream("/druid.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得dataSourse
     * @return  已经初始化的DataSource
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取数据库连接
     * @return Connection
     */
    public static Connection getConnection(){
        try {
//            return dataSource.getConnection()
            connection =dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到JdbcTemplat
     * @return JdbcTemplat
     */
    public static JdbcTemplate getTemplate(){
        template= new JdbcTemplate(dataSource);
        return template;
    }
    /**
     * 关闭Connection
     */
    public void Close(){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
