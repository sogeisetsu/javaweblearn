package suyuesheng.dbcserverce;

import suyuesheng.vo.User;

/**
 * 接口 User表数据库业务层接口
 * @author 苏月晟
 */
public interface IUserService {
    /**
     * 根据user信息查询是否又该任务
     * @param user 用户信息
     * @return 有该人物就返回True，没有该人物就返回False
     * @throws Exception
     */
    public Boolean Query(User user) throws Exception;

    /**
     * 返回符合loginUser内容的User类，如果没有就返回null
     * @param loginUser 接收到的要登陆的User类
     * @return 返回User类或null
     * @throws Exception
     */
    public User text(User loginUser) throws Exception;
}
