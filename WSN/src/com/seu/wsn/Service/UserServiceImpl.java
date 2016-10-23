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
 * @Description: �߼���ӿ�ʵ����
 * @author: CSS
 * @date: 2016-10-23 ����11:25:07
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;	
	
	/**
	 * ע��userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * �������ݷ��ʲ㷽��ѡ���û�
	 */
	@Override
	public User select(String userName) {
		return userDao.select(userName);
	}

	/**
	 * �������ݷ��ʲ㷽�������û�
	 */
	@Override
	public void insert(User user) {
		user.setOnLine(false);  //Ĭ���û�������
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		user.setRegisterDate(df.format(new Date()));
		userDao.insert(user);
	}

	/**
	 * �������ݷ��ʲ㷽�������û���Ϣ
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	/**
	 * �������ݷ��ʲ㷽��ɾ���û�
	 */
	@Override
	public void remove(String userName) {
		userDao.remove(userName);
	}

	/**
	 * �������ݷ��ʲ㷽����ȡ�û��б�
	 */
	@Override
	public List<User> userList() {
		return userDao.userList();
	}


	

}
