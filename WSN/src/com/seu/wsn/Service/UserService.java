package com.seu.wsn.Service;

import java.util.List;

import com.seu.wsn.Core.Pojo.User;
/**
 * 
 * @ClassName: UserService 
 * @Description: 业务逻辑层接口
 * @author: CSS
 * @date: 2016-10-23 上午11:24:43
 */
public interface UserService {
	/**
	 * 根据用户名选择用户
	 * @param userName
	 * @return
	 */
	public User select(String userName);
	
	/**
	 * 添加一个新的用户
	 * @param user
	 */
	public void insert(String userName,String pwd);
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void update(User user); 
	
	/**
	 * 删除一个用户
	 * @param userName
	 */
	public void remove(String userName);
	
	/**
	 * 返回所有用户
	 * @return
	 */
	public List<User> userList();
}
