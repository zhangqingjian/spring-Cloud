package com.yo.news.clip.impl;

import java.sql.Connection;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
public abstract  class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>
{
	protected static Logger logAPI = Logger.getLogger(BaseDaoImpl.class.getName());

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	
	}

	/**
	 * 获取相关的数据库连接
	 */
	public Connection getConnection()
	{
		return getSqlSession().getConnection();
	}

	 
	 
  
}
