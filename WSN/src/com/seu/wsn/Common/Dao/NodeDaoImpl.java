package com.seu.wsn.Common.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seu.wsn.Core.Pojo.Node;
/**
 * 
 * @ClassName: NodeDaoImpl 
 * @Description: �ڵ����ݷ��ʲ�ʵ����
 * @author: CSS
 * @date: 2016-11-3 ����10:00:35
 */
@Repository("nodeDao")
public class NodeDaoImpl extends SqlSessionDaoSupport implements NodeDao{
	/**
	 * ע��SqlSessionFactory
	 */
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * ����ڵ�
	 */
	@Override
	public void insert(Node node) {
		getSqlSession().insert("com.seu.wsn.node.mapper.insertNode", node);
		
	}
	/**
	 * ���½ڵ���Ϣ
	 */
	@Override
	public void update(Node node) {
		getSqlSession().update("com.seu.wsn.node.mapper.updateNode", node);
		
	}
	/**
	 * ��ȡ�ڵ��б�
	 */
	@Override
	public List<Node> nodeList() {
		return getSqlSession().selectList("com.seu.wsn.node.mapper.nodeList");
	}
	/**
	 * ���ݲ��Ա�Ż�ȡ�ڵ��б�
	 */
	@Override
	public List<Node> getNodeListByTestId(String testId) {
		return getSqlSession().selectList("com.seu.wsn.node.mapper.nodeListByTestId",testId);
	}

}
