package com.wechat.business.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.business.bean.User;
import com.wechat.business.service.IUserService;

@Controller
@RequestMapping("/user") 
public class UserController {

	@Autowired
	private IUserService userService;
	
	private Logger log = Logger.getLogger(this.getClass());
	
    @RequestMapping("/queryAll") 
    public String queryAll(Model model) throws Exception {
    	
    	List<User> users = userService.queryAll();
    	model.addAttribute("users", users);
        return "my";
    }
    @RequestMapping("/add") 
    public String add(Model model) throws Exception {
    	
    	User user = new User();
    	user.setName("zhaoliu");
    	user.setAge(2);
    	boolean a = userService.addUser(user);
    	
    	List<User> users =new ArrayList<User>();
    	users.add(user);
    	model.addAttribute("users", users);
    	
    	return "my";
    }
    @RequestMapping("/log") 
    public String log(Model model) throws Exception {
    	
    	log.info("wechat测试日志的过程");
    	
    	List<User> users = userService.queryAll();
    	model.addAttribute("users", users);
    	return "my";
    }
}