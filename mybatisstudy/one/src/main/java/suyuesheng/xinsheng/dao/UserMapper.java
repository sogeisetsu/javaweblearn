package suyuesheng.xinsheng.dao;

import com.sun.org.glassfish.gmbal.Description;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import suyuesheng.xinsheng.pojo.User;

import java.util.List;

/**
 * Dao 对用户的增查删改
 * @author 苏月晟
 */
public interface UserMapper {
    /**
     * 获得所有的user信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查找用户
     * @param id 用户id
     * @return 返回用户
     */
    User findById(int id);

    /**
     * 插入用户
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     * 更改用户
     * @param user
     * @return bollean
     */
    boolean updateUser(User user);

    boolean deleteUser( User user);

    @Delete("delete from user where id=#{id}")
    boolean deleteById(@Param("id") int id);


    List<User> findByName(@Param("name") String name);
}
