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
 * @Description: 节点数据访问层实现类
 * @author: CSS
 * @date: 2016-11-3 上午10:00:35
 */
@Repository("nodeDao")
public class NodeDaoImpl extends SqlSessionDaoSupport implements NodeDao{
	/**
	 * 注入SqlSessionFactory
	 */
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 插入新节点
	 */
	@Override
	public void insert(Node node) {
		getSqlSession().insert("com.seu.wsn.node.mapper.insertNode", node);
		
	}
	/**
	 * 更新节点信息
	 */
	@Override
	public void update(Node node) {
		getSqlSession().update("com.seu.wsn.node.mapper.updateNode", node);
		
	}
	/**
	 * 获取节点列表
	 */
	@Override
	public List<Node> nodeList() {
		return getSqlSession().selectList("com.seu.wsn.node.mapper.nodeList");
	}
	/**
	 * 根据测试编号获取满足条件的节点列表
	 */
	@Override
	public List<Node> getNodeListByTestId(String testId) {
		return getSqlSession().selectList("com.seu.wsn.node.mapper.nodeListByTestId",testId);
	}

}
