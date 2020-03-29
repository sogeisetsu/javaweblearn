package jedis.suyueshneg.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static JdbcTemplate jdbcTemplate;
    private static Connection connection;
    private static DataSource dataSource;
    static {
        Properties pro = new Properties();
        InputStream inputStream = DatabaseConnection.class.getResourceAsStream("/druid1.properties");
        try {
            pro.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接的jdbctemplate
     * @return
     */
    public static JdbcTemplate getJdbcTemplate() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
//        return jdbcTemplate;
    }

    public static Connection getConnection() {
        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
//        return connection;
    }

    public static DataSource getDataSource() {
        return dataSource;
//        return dataSource;
    }
    public void close(){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
