package cn.suyuesheng.dao;

import cn.suyuesheng.domain.User;

import java.util.List;

/**
 * 数据访问层接口
 * @author 苏月晟
 */
public interface IUserDao {
    /**
     * 查询操作，查询所有的User的全部信息，并将每一个用户信息封装在各自User类上，返回User类的List
     * @return 如果由用户就返回List 如果没有用户就返回List的集合长度为0
     */
    public List<User> findALL() throws Exception;

    /**
     * 根据id号来获得User
     * @param id id号
     * @return User 用户类  如果没有和该ID相匹配的就返回Null
     * @throws Exception
     */
    public User findById(Integer id) throws Exception;

    /**
     * 根据User类的id 来更新数据库该user的内容，是之和该User类一致。update操作
     * @param user User类
     * @return 如果有该用户且修改成功就返回True，否则返回False
     * @throws Exception
     */
    public Boolean update(User user) throws Exception;

    /**
     * 按照全部，查看是否有该用户
     * @param user
     * @return 有就返回True
     * @throws Exception
     */
    public Boolean check(User user) throws Exception;

    /**
     * 有没有该ID的用户
     * @param id
     * @return 有就返回True
     * @throws Exception
     */
    public Boolean check(Integer id) throws Exception;

    /**
     * 获得位置为address的用户集合
     * @param address
     * @return 如果没有就返回长度为0的集合
     * @throws Exception
     */
    public List<User> findByAddress(String address) throws Exception;

    /**
     * 判断是否有符合名字和密码的用户
     * @param name 名字
     * @param password  密码
     * @return 返回用户类 User 如果没有就返回null
     * @throws Exception
     */
    public User findByNameAndFindByPassword(String name ,String password) throws Exception;
    public List<User> findByNameAndFindByAddressAndFindByEmail(String name,String address,String email) throws Exception;
}
