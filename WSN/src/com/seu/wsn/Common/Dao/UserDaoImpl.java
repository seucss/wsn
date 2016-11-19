package com.seu.wsn.Common.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.seu.wsn.Core.Pojo.User;
/**
 * 
 * @ClassName: UserDaoImpl 
 * @Description: UserDaoImpl
 * @author: CSS
 * @date: 2016-10-23 上午11:23:18
 */
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	/**
	 * 注入SqlSessionFactory
	 */
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/**
	 *获取用户列表
	 */
	@Override
	public List<User> userList() {
		return getSqlSession().selectList("com.seu.wsn.user.mapper.userList");
	}
	/**
	 * 根据用户名选择用户
	 */
	@Override
	public User select(String userName) {
		return getSqlSession().selectOne("com.seu.wsn.user.mapper.selectUser", userName);
	}
	/**
	 * 新增用户
	 */
	@Override
	public void insert(User user) {
		getSqlSession().insert("com.seu.wsn.user.mapper.insertUser", user);
	}
	/**
	 * 更新用户信息
	 */
	@Override
	public void update(User user) {
		getSqlSession().update("com.seu.wsn.user.mapper.updateUser", user);
	}
	/**
	 * 更加用户名删除用户
	 */
	@Override
	public void remove(String userName) {
		getSqlSession().delete("com.seu.wsn.user.mapper.removeUser", userName);
	}

}
