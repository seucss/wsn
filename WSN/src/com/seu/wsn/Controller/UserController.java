package com.seu.wsn.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seu.wsn.Service.UserService;

/**
 * 
 * @ClassName: UserController 
 * @Description: userController
 * @author: CSS
 * @date: 2016-10-23 上午11:25:32
 */
@Controller
public class UserController{
	@Autowired
	private UserService userService;
	
	/**
	 * 注入userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 
	 * @Title: userList 
	 * @Description: 接收用户请求，返回用户列表
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/list")
	public String userList(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		
		model.put("list", userService.userList());
		
		return "homePage//userLogin";
	}
}
