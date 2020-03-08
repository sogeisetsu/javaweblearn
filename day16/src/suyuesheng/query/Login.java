package suyuesheng.query;

import suyuesheng.dbc.DatabaseConnection;
import suyuesheng.factory.ServiceFactory;
import suyuesheng.vo.User;

/**
 * 将获取的请求信息和数据库比对
 * @author 苏月晟
 */
@Deprecated
public class Login {
    /**
     * 将获取的请求信息和数据库比对
     * @param user 或取得请求信息
     * @return 如果比对不成功就返回null
     * @throws Exception
     */
    public static User query(User user) throws Exception {
//        User user1 = new User();
//        Boolean bb=ServiceFactory.getUserServiceInstance(DatabaseConnection.getTemplate()).Query(user);
//        if(bb){
//            user1.setName(user.getName());
//            user1.setPassWord(user.getPassWord());
//            return user1;
//        }
//        return null;
        return ServiceFactory.getUserServiceInstance(DatabaseConnection.getTemplate()).text(user);
    }
}
