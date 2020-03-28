package tk.suyuesheng.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    private static DataSource dataSource;
    private static Connection connection;
    private static JdbcTemplate template;
    static {
        Properties properties = new Properties();

        InputStream inputStream = DataBaseConnection.class.getResourceAsStream("/druid.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
          dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取datasourse
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static JdbcTemplate getTemplate(){
        template = new JdbcTemplate(dataSource);
        return template;
    }
    public static void close(){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
