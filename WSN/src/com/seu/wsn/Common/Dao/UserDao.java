package com.seu.wsn.Common.Dao;

import java.util.List;

import com.seu.wsn.Model.Pojo.User;

/**
 * 
 * @ClassName: UserDao 
 * @Description: ���ݷ��ʲ�ӿ�UserDao
 * @author: CSS
 * @date: 2016-10-23 ����11:24:11
 */
public interface UserDao {
	
	/**
	 * �����û���ѡ���û�
	 * @param userName
	 * @return
	 */
	public User select(String userName);
	
	/**
	 * ���һ���µ��û�
	 * @param user
	 */
	public void insert(User user);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 */
	public void update(User user); 
	
	/**
	 * ɾ��һ���û�
	 * @param userName
	 */
	public void remove(String userName);
	
	/**
	 * ���������û�
	 * @return
	 */
	public List<User> userList();

}
