package com.seu.wsn.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seu.wsn.Common.Dao.UserDao;
import com.seu.wsn.Model.Pojo.User;
/**
 * 
 * @ClassName: UserServiceImpl 
 * @Description: 逻辑层接口实现类
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
	 * 调用数据访问层方法选择用户
	 */
	@Override
	public User select(String userName) {
		return userDao.select(userName);
	}

	/**
	 * 调用数据访问层方法新增用户
	 */
	@Override
	public void insert(User user) {
		user.setOnLine(false);  //默认用户不在线
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		user.setRegisterDate(df.format(new Date()));
		userDao.insert(user);
	}

	/**
	 * 调用数据访问层方法更新用户信息
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	/**
	 * 调用数据访问层方法删除用户
	 */
	@Override
	public void remove(String userName) {
		userDao.remove(userName);
	}

	/**
	 * 调用数据访问层方法获取用户列表
	 */
	@Override
	public List<User> userList() {
		return userDao.userList();
	}


	

}
