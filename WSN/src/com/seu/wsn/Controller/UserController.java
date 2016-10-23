package com.seu.wsn.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seu.wsn.Service.UserService;


@Controller
public class UserController{
	@Autowired
	private UserService userService;
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping("/list")
	public String hello(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		
		model.put("list", userService.list());
		
		return "homePage//userLogin";
	}
}
