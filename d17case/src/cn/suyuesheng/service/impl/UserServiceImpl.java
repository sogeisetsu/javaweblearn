package cn.suyuesheng.service.impl;

import cn.suyuesheng.dao.impl.UserDaoImpl;
import cn.suyuesheng.domain.User;
import cn.suyuesheng.service.IUserService;
import cn.suyuesheng.util.BeanPage;
import cn.suyuesheng.util.DataBaseConnection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements IUserService {
    private JdbcTemplate template = DataBaseConnection.getTemplate();
    @Override
    public List<User> findAll() throws Exception {
        List<User> users = new UserDaoImpl(template).findALL();
        return users;
    }

    @Override
    public Boolean login(User user) throws Exception {
        User login = new UserDaoImpl(template).findByNameAndFindByPassword(user.getName(), user.getPassword());
        if(login==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public User getLogin(User user) throws Exception {
        User loginUser = new UserDaoImpl(template).findByNameAndFindByPassword(user.getName(), user.getPassword());
        return loginUser;
    }

    @Override
    public Boolean addUser(User user) throws Exception {
        User userByName = new UserDaoImpl(template).findByName(user.getName());
        if(userByName!=null){
            return false; //该数据曾存在，所以不能添加
        }else{
            Boolean aBoolean = new UserDaoImpl(template).addUser(user);
            return aBoolean;
        }
    }

    @Override
    public Boolean delete(Integer id) throws Exception {
        Boolean aBoolean = new UserDaoImpl(template).deleteById(id);
        return aBoolean;
    }

    @Override
    public User findById(Integer id) throws Exception {
        User byId=null;
        try {
            byId = new UserDaoImpl(template).findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return byId;
    }

    @Override
    public Boolean update(User user) throws Exception {
        Boolean update = new UserDaoImpl(template).update(user);
        return update;
    }

    @Override
    public Boolean deleteByIds(String[] ids) throws Exception {
        Boolean z=true;
        for(String id:ids){
            Integer item = Integer.parseInt(id);
            try {
                Boolean aBoolean = new UserDaoImpl(template).deleteById(item);
                if(aBoolean==false){
                    z=false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    @Override
    public BeanPage<User> findUserByPage(int currentPage, int rows, Map<String, String[]> map) throws Exception {
        BeanPage<User> userBeanPage = new BeanPage<User>();
        int totalCount = new UserDaoImpl(template).totalCount(map);
        userBeanPage.setRows(rows);
        int totalPage=totalCount%rows==0 ? totalCount/rows:(totalCount/rows)+1;
        userBeanPage.setTotalPage(totalPage);
        if(currentPage>totalPage && totalPage!=0){
            currentPage=totalPage;
        }else if(currentPage<=0 ||totalPage==0){
            currentPage=1;
        }
        userBeanPage.setCurrentPage(currentPage);
        userBeanPage.setTotalCount(totalCount);

        int start=(currentPage-1)*rows;
        System.out.println(start);
        System.out.println(rows);
        List<User> users = new UserDaoImpl(template).findByPage(start, rows,map);
        userBeanPage.setList(users);

        return userBeanPage;
    }
}
