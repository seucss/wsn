package com.seu.wsn.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seu.wsn.Common.Dao.UserDao;
import com.seu.wsn.Model.Pojo.User;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

}
