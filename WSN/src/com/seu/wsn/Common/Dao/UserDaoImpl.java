package com.seu.wsn.Common.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.seu.wsn.Model.Pojo.User;
/**
 * 
 * @ClassName: UserDaoImpl 
 * @Description: UserDaoImpl
 * @author: CSS
 * @date: 2016-10-23 ����11:23:18
 */
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	/**
	 * ע��SqlSessionFactory
	 */
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/**
	 * ��ȡ�û��б�
	 */
	@Override
	public List<User> userList() {
		return getSqlSession().selectList("com.seu.wsn.user.mapper.userList");
	}
	/**
	 * �����û���ѡ���û�
	 */
	@Override
	public User select(String userName) {
		return getSqlSession().selectOne("com.seu.wsn.user.mapper.selectUser", userName);
	}
	/**
	 * ����һ���û�
	 */
	@Override
	public void insert(User user) {
		getSqlSession().insert("com.seu.wsn.user.mapper.insertUser", user);
	}
	/**
	 * �����û���Ϣ
	 */
	@Override
	public void update(User user) {
		getSqlSession().update("com.seu.wsn.user.mapper.updateUser", user);
	}
	/**
	 * ɾ���û�
	 */
	@Override
	public void remove(String userName) {
		getSqlSession().delete("com.seu.wsn.user.mapper.removeUser", userName);
	}

}
