package com.seu.wsn.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.wsn.Core.Pojo.Node;
import com.seu.wsn.Core.Pojo.User;
import com.seu.wsn.Core.StaticConst.WebConst;
import com.seu.wsn.SensorController.ServerController;
import com.seu.wsn.Service.NodeService;
import com.seu.wsn.Service.UserService;

/**
 * 
 * @ClassName: UserController 
 * @Description: userController
 * @author: CSS
 * @date: 2016-10-23 ����11:25:32
 */
@Controller
public class UserController{
	@Autowired
	private UserService userService;
	@Autowired
	private NodeService nodeService;
	
	/**
	 * ע��userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * ע��nodeService
	 */
	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: ��¼
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
			String userName,String pwd,String testId){
		List<Node> nodeList = nodeService.getNodeListByTestId(testId);
		if(nodeList.size()>0){
			model.put(WebConst.ERROR_MSG, "testId");
			return  WebConst.INDEX;
		}
		User user = userService.select(userName);
		if(user!=null){ 
			if(userName.equals(user.getUserName())&&pwd.equals(user.getPwd())){
				req.getSession().setAttribute(WebConst.USERNAME, userName);
				new Thread(new ServerController(testId,nodeService)).start();
				return WebConst.NODE_INFO;
			}
		}
		model.put(WebConst.ERROR_MSG, "nameOrpwd");
		return  WebConst.INDEX;
	}
	/**
	 * 
	 * @Title: register 
	 * @Description: �û�ע��
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
	 * @Description: �����û���¼ҳ��
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
	 * @Description: ���ע�����Ƿ�Ψһ
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
	 * @Description: �ύ�û�ע����Ϣ
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
	 * @Description: �����û����󣬷����û��б�
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
