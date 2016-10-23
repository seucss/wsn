package com.seu.wsn.Common.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.seu.wsn.Model.Pojo.User;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("com.seu.wsn.user.mapper.list");
	}

}
