package tk.suyuesheng.util.fectory;

import tk.suyuesheng.service.impl.UserServiceImpl;

public class DomainFectory {
    public static UserServiceImpl getUserService(){
        return new UserServiceImpl();
    }
}
