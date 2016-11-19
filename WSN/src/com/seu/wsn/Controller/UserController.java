package com.seu.wsn.Controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.wsn.Core.Pojo.User;
import com.seu.wsn.Core.StaticConst.WebConst;
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
	 * @Title: login 
	 * @Description: 用户登录请求
	 * @param req
	 * @param resp
	 * @param model
	 * @param userName
	 * @param pwd
	 * @return
	 * @return: String
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest req,HttpServletResponse resp,ModelMap model,
			String userName,String pwd){
		
		User user = userService.select(userName);
		if(user!=null){ 
			if(userName.equals(user.getUserName())&&pwd.equals(user.getPwd())){
				req.getSession().setAttribute(WebConst.USERNAME, userName);
				return WebConst.INTRODUCTION;
			}
		}
		model.put(WebConst.ERROR_MSG, "nameOrpwd");
		return  WebConst.INDEX;
	}
	/**
	 * 
	 * @Title: register 
	 * @Description: 返回注册页面
	 * @param req
	 * @param resp
	 * @param model
	 * @param userName
	 * @param pwd
	 * @return
	 * @return: String
	 */
	@RequestMapping("/register")
	public String register(HttpServletRequest req,HttpServletResponse resp,ModelMap model,
			String userName,String pwd){
		return  WebConst.USER_REGISTER;
	}
	/**
	 * 
	 * @Title: loginUser 
	 * @Description: 用户登录
	 * @param req
	 * @param resp
	 * @param model
	 * @param userName
	 * @param pwd
	 * @return
	 * @return: String
	 */
	@RequestMapping("/userLogin")
	public String loginUser(HttpServletRequest req,HttpServletResponse resp,ModelMap model,
			String userName,String pwd){
		return  WebConst.INDEX;
	}
	/**
	 * 
	 * @Title: checkUnique 
	 * @Description: 判断用户名是否唯一
	 * @param req
	 * @param resp
	 * @param model
	 * @param userName
	 * @return: void
	 */
	@RequestMapping("/checkUnique")
	@ResponseBody
	public ModelMap checkUnique(HttpServletRequest req,HttpServletResponse resp,ModelMap model,
			String userName){
		User user = userService.select(userName);
		if(user==null){
			model.put(WebConst.MESSAGE, "true");
		}else{
			model.put(WebConst.MESSAGE, "false");
		}
		return model;
	}
	/**
	 * 
	 * @Title: registerUser 
	 * @Description: 用户注册
	 * @param req
	 * @param resp
	 * @param model
	 * @param userName
	 * @param pwd
	 * @return
	 * @return: ModelMap
	 */
	@RequestMapping("/registerUser")
	@ResponseBody
	public ModelMap registerUser(HttpServletRequest req,HttpServletResponse resp,ModelMap model,
			String userName,String pwd){
		userService.insert(userName,pwd);
		model.put(WebConst.MESSAGE, "true");
		return model;
	}

	/**
	 * 
	 * @Title: userList 
	 * @Description: 获取用户列表
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("/list")
	public String userList(HttpServletRequest req,HttpServletResponse resp,ModelMap model){
		
		model.put("list", userService.userList());
		
		return WebConst.USER_LOGIN;
	}
}
