package com.demo.firt.controller;

import com.demo.firt.model.Address;
import com.demo.firt.model.User;
import com.demo.firt.service.AddressService;
import com.demo.firt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


/**
 * @Controller 控制层
 * @GetMapping("/login.html")   自动映射到login.html
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;
    @GetMapping("/login.html")
    public String loginPage(HttpSession session){
        boolean flag = session.getAttribute("loginUser") == null ? true:false;
        if(flag){
            return "login";
        }else{
            return "redirect:/main.html";
        }
    }

    @GetMapping("/main.html")
    public String main(){
        return "main";
    }

    @GetMapping("/userlist.html")
    public String userlist(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "userlist";
    }

    @GetMapping("/adduser.html")
    public String adduser(Model model){
        //需要获取所有的地址信息
        List<Address> allAddress= addressService.getAllAddress();
        model.addAttribute("addresses",allAddress);
        return "adduser";
    }
    @PostMapping("/adduser.html")
    public String adduser(User user){
        user.setRegDate(new Date());
        userService.add(user);
        return "redirect:/userlist.html";
    }
    //模糊查询
    @PostMapping("/userSearch.html")
    public String userSearch(String searchByUsername,Model model){
        //JPA中模糊查询  传递参数中加“%”+ 参数 + “%”
        List<User> users = userService.getByUsernameLike("%" + searchByUsername + "%");
        model.addAttribute("users",users);
        return "userlist";
    }
    //判断登录
    @PostMapping("/login.html")
    public String login(User user, HttpSession session, Model model){
        //接收页面的用户名和密码的控制层
        //调用服务层的login方法，判断是否登陆成功
        //成功，返回一个user对象保存到session的域空间
        //不成功，给登录界面返回一个错误提示
        User user1 = userService.login(user);
        if(user1 != null){
            //存到session的域空间
            session.setAttribute("loginUser",user1);
            //跳转到主页面
            return "redirect:/main.html";
        }else {
            //跳转login页面，
            model.addAttribute("loginErr","用户名或密码有误");
            return "login";
        }
    }

    @GetMapping("/logout.html")
    public String logout(HttpSession session){
        //清空域空间的session中的内容
        session.invalidate();
        //重定向到login页面
        return "redirect:/login.html";
    }

    @GetMapping("/updateuser.html")
    public String updateuser(Model model,Integer id){
        //注入模板里面有两个对象，一个是所有的地址信息的集合，一个是选中修改的用户的记录信息
        User user = userService.get(id);
        model.addAttribute(user);
        //需要获取所有的地址信息
        List<Address> allAddress= addressService.getAllAddress();
        model.addAttribute("addresses",allAddress);
        return "updateuser";
    }

    @PostMapping("/updateuser.html")
    public String updateUser(User user){
        System.out.println("User" + user);
        userService.update(user);
        return "redirect:/userlist.html";
    }

    @GetMapping("/deleteuser.html")
    public String deleteuser(Integer id){
        userService.delete(id);
        return "redirect:/userlist.html";
    }
}
