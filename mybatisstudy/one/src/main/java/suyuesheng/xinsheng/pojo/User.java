package suyuesheng.xinsheng.pojo;

import java.util.Date;

/**
 * @description: 用户类
 * @author 苏月晟
 * @date 2020/8/5 20:25
 * @version 1.0
 */
public class User {
    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public User(int id, String name, String pwd, Date birthday) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.birthday = birthday;
    }

    private int id;
    private String name;
    private String pwd;
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
