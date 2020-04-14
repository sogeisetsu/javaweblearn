package cn.ssm.suyuesheng;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUT {
    private static DataSource dataSource;
    private static JdbcTemplate template;
    static {
        Properties properties =new Properties();
        InputStream inputStream = JDBCUT.class.getResourceAsStream("/druid.properties");
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
        template=new JdbcTemplate(dataSource);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static JdbcTemplate getTemplate() {
        return template;
    }
}
