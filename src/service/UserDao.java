package service;

import pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
   public User Login(User user);

//    public  List<User> tableuser();




    public List<User> selectpage(HashMap map);

    public   Integer usercount();

    public int deleteUserByid(Integer id);

    public int addUser(User user);

    public int updatetable(User user);

 public int rusercount();
}
