package mapper;


import pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    public User Login(User user);

//    public List<User> tableuser();


    public  List<User> selectpage(HashMap map);

    public  Integer usercount();

    public int deleteUserByid(Integer id);

    public int addUser(User user);

//    public List<User> tablelayui();
//
//    public List<User> selectpage(HashMap map);
//
//    public Integer usercount();
//
//    public  int updatetable(User user);
//
//    public  int deleteUserByid(Integer user_id);
//
//    public User addUserPage(User user);
//
//    public int updatehead(User user);

}
