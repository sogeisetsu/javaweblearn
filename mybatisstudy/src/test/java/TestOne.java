import cn.ssm.suyuesheng.JDBCUT;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestOne {
    @Test
    public void Testv(){
        JdbcTemplate template = JDBCUT.getTemplate();
    }
}
