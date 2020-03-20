package club.suyuesheng;

import club.suyuesheng.vo.User;
import club.suyuesheng.dbc.DatabaseConnection;
import club.suyuesheng.factory.ServiceFactory;

public class Test {
    public static void main(String[] args) throws Exception {
        User jj = new User("11", "jj");
        System.out.println(ServiceFactory.getUserServiceInstance(DatabaseConnection.getTemplate()).text(jj)==null);

    }
}
