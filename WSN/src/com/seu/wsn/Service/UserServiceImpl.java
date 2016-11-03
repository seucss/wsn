package com.seu.wsn.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seu.wsn.Common.Dao.UserDao;
import com.seu.wsn.Core.Pojo.User;
/**
 * 
 * @ClassName: UserServiceImpl 
 * @Description: 用户管理业务逻辑层实现类
 * @author: CSS
 * @date: 2016-10-23 上午11:25:07
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;	
	
	/**
	 * 注入userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 根据用户名选择用户
	 */
	@Override
	public User select(String userName) {
		return userDao.select(userName);
	}

	/**
	 * 新增用户
	 */
	@Override
	public void insert(String userName,String pwd) {
		User user = new User();
		user.setUserName(userName);
		user.setPwd(pwd);
		user.setOnLine(false);  //新用户设置离线
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		user.setRegisterDate(df.format(new Date()));
		userDao.insert(user);
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	/**
	 * 根据用户名删除用户
	 */
	@Override
	public void remove(String userName) {
		userDao.remove(userName);
	}

	/**
	 * 获取用户列表
	 */
	@Override
	public List<User> userList() {
		return userDao.userList();
	}


	

}
