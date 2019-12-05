package controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.User;
import service.UserDao;
import tool.Tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class Userconnn {
    @Autowired
    UserDao userDao;
    @Autowired
    HttpServletRequest request;



//登录
    @RequestMapping("/loginLayui.action")
    @ResponseBody
    public User Login(@RequestBody User user) {
        HttpSession session = request.getSession();
        User login = userDao.Login(user);
        if (login != null) {
            session.setAttribute("user", login);
         return login;
        } else {
           return null;
        }
    }

//    //没有分页的列表
//    @RequestMapping("/tableLayui.action")
//    @ResponseBody
//    public Map<String, Object> tableLayui() {
//        List<User> users = userDao.tablelayui();
//        return Tool.testLayui(users, 0, 0);
//    }
//    //点击列表一跳转至列表页面
//    @RequestMapping("/tableLayuiPage.action")
//    public String tableLayuiPage() {
//        return "table";
//    }
//
//    @RequestMapping("/back.action")
//    public String back() {
//        return "back";
//    }
//
//
//    //分页
//    @RequestMapping("/selectlayuitable.action")
//    @ResponseBody
//    public Map<String, Object> selectlayuitable(int page, int limit, String name, String loginName) {
//        HashMap<String, Object> map = new HashMap<>();
//        int pagestart = (page - 1) * limit;
//        map.put("pagestart", pagestart);
//        map.put("limit", limit);
//        map.put("name", name);
//        map.put("loginName", loginName);
//        List<User> users = userDao.selectpage(map);
//        Integer pagecount = userDao.usercount();
//        Map<String, Object> returnTable = Tool.testLayui(users, page, limit);
//        returnTable.put("count", pagecount);
//        return returnTable;
//    }
//
//    @RequestMapping("/updatehead.action")
//    @ResponseBody
//    public Map<String, Object> updatehead(MultipartFile file, int user_id) throws IOException {
//        Map<String, Object> map = new HashMap<>();
//        String filename = UUID.randomUUID().toString().replaceAll("-", "");
//        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//        filename = filename + "." + extension;
//        String path = "D:\\upload";
////        file.transferTo(new File("D:\\upload\\" + filename));
//        User user = new User();
//        user.setUser_id(user_id);
//        user.setHeadpath(filename);
//        int update = userDao.updatehead(user);
//        if (update > 0) {       //当数据库有记录时才上传文件
//            file.transferTo(new File("D:\\upload\\" + filename));
//        }
//        File dir = new File(path, filename);
//        if (dir.exists()) {    //当有文件时上传记录
//            update = userDao.updatehead(user);
//        }
//        if (dir.exists() && update < 1) {     //数据库有记录但是文件上传失败
//            dir.delete();
//            map.put("msg", "上传失败");
//            map.put("code", 1);
//        } else if (!dir.exists() && update > 0) {    //数据库无记录但是文件上传成功
//            user.setHeadpath(null);
//            userDao.updatehead(user);
//            dir.delete();
//            map.put("msg", "上传失败");
//            map.put("code", 1);
//        } else if (!dir.exists() && update < 1) {      //数据库无记录文件也未上传成功
//            dir.delete();
//            map.put("msg", "上传失败");
//            map.put("code", 1);
//        } else {             //数据库有记录文件也上传成功
//            dir.mkdirs();
//            map.put("msg", "上传成功");
//            map.put("code", 0);
//            map.put("src", "http://localhost:8086/pic/" + filename);
//        }
//        return map;
//    }
//    @RequestMapping("/updatetable.action")
//    @ResponseBody
//   public int updatetable(User user){
//        return userDao.updatetable(user);
//    }
//
//
//    @RequestMapping("/deleteUserByid.action")
//    @ResponseBody
//    public int deleteUserByid(Integer user_id) throws Exception {
//        int  result =   userDao.deleteUserByid(user_id);
//        return  result;
//    }
//
//    @RequestMapping("/deleteAll.action")
//    @ResponseBody
//    public int deleteAll(String user_ids)  {
//        boolean b = user_ids.endsWith(",");
//        if (b){
//            user_ids = user_ids.substring(0,user_ids.length() - 1);
//        }
//        String[] ids = user_ids.split(",");
//        int re = 0;
//        for (String user_id: ids) {
//            re = userDao.deleteUserByid(Integer.parseInt(user_id));
//        }
//        return re;
//    }
//
////
//@RequestMapping("/addUserPage1.action")
//public String addUserPage1() {
//    return "addtable";
//}
//
//
//@RequestMapping("/addUserPage.action")
//@ResponseBody
//public Map<String,String> addUserPage(@RequestBody User user) {
//    HttpSession session = request.getSession();
//    User addUser = userDao.addUserPage(user);
//    Map<String,String> msg = new HashMap<>();
//    if (addUser != null) {
//        session.setAttribute("user", addUser);
//        msg.put("msg","success");
//        return msg;
//    } else {
//        msg.put("msg","false");
//        return msg;
//    }
//}
}
