package club.suyuesheng.dbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static DataSource  dataSource= null;
    private static Connection connection = null;
    private static JdbcTemplate  template = null;
    static {
        Properties pro = new Properties();
        InputStream inputStream = DatabaseConnection.class.getResourceAsStream("/druid.properties");
        try {
            pro.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        try{
            connection = dataSource.getConnection();
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static JdbcTemplate getTemplate(){
        try{
            template=new JdbcTemplate(dataSource);
            return template;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
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