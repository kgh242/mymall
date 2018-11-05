package com.test.mymall.commons;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBHelper {
	
	private DBHelper() {}
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSessionFactory getSqlSessionFactory() throws IOException{
		if(sqlSessionFactory == null) {
			System.out.println("sqlSessionFactory == null");
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			return new SqlSessionFactoryBuilder().build(inputStream);
		}
		return sqlSessionFactory;
	}
	public static SqlSession getSqlSession() throws IOException{
		sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
