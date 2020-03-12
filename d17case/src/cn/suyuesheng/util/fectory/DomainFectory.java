package cn.suyuesheng.util.fectory;

import cn.suyuesheng.service.impl.UserServiceImpl;

public class DomainFectory {
    public static UserServiceImpl getUserService(){
        return new UserServiceImpl();
    }
}
