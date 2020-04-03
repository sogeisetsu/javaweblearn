package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //看用户是否存在
        User byUsername = userDao.findByUsername(user.getUsername());
        if(byUsername!=null){
            return false;
        }
        user.setCode(UuidUtil.getUuid());
        user.setStatus("n");
        //发送邮件
        String content = "<h1>欢迎注册</h1><hr><a href=\"http://localhost/travel/user/activeUser?code="+user.getCode()+"\"> 请点击注册,您的注册码为"+user.getCode()+"</a><p>如有问题，请联系客服。</p><hr><p>如此邮件和您无关，请忽略该邮件，抱歉</p>";
        MailUtils.sendMail(user.getEmail(), content, "验证邮件");
        userDao.save(user);
        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }



    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

}
