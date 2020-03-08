package suyuesheng;

import suyuesheng.dbc.DatabaseConnection;
import suyuesheng.factory.ServiceFactory;
import suyuesheng.vo.User;

public class Test {
    public static void main(String[] args) throws Exception {
        User jj = new User("11", "jj");
        System.out.println(ServiceFactory.getUserServiceInstance(DatabaseConnection.getTemplate()).text(jj)==null);

    }
}
